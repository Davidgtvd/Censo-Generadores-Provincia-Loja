package com.lojageneradores.censo.dao.implement;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.lojageneradores.tda.list.LinkedList;

public class AdapterDao<T, K> implements InterfazDao<T, K> {

    private final Class<T> clazz;
    private final Gson gson;
    public static final String URL = "media/";

    public AdapterDao(Class<T> clazz) {
        this.clazz = clazz;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public T buscar(K id) {
        LinkedList<T> list = listar();
        for (T item : list.toArray()) {
            if (id.equals(getId(item))) {
                return item;
            }
        }
        return null;
    }

    private K getId(T obj) {
        try {
            Method method = clazz.getMethod("getId");
            @SuppressWarnings("unchecked")
            K id = (K) method.invoke(obj);
            return id;
        } catch (Exception e) {
            System.err.println("Error al obtener el ID: " + e.getMessage());
        }
        return null;
    }

    @Override
    public LinkedList<T> listar() {
        LinkedList<T> list = new LinkedList<>();
        try {
            String data = leerArchivo();
            if (data != null && !data.isEmpty()) {
                Type type = TypeToken.getParameterized(LinkedList.class, clazz).getType();
                LinkedList<T> items = gson.fromJson(data, type);
                for (T item : items.toArray()) {
                    list.add(item);
                }
            }
        } catch (JsonSyntaxException e) {
            System.err.println("Error al listar los datos: " + e.getMessage());
        }
        return list;
    }

    @Override
    public boolean guardar(T entidad) {
        try {
            LinkedList<T> list = listar();
            list.add(entidad);
            escribirArchivo(gson.toJson(list.toArray()));
            return true;
        } catch (Exception e) {
            System.err.println("Error al guardar el dato: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(K id) {
        try {
            LinkedList<T> list = listar();
            for (int i = 0; i < list.size(); i++) {
                if (id.equals(getId(list.get(i)))) {
                    list.remove(i);
                    break;
                }
            }
            escribirArchivo(gson.toJson(list.toArray()));
            return true;
        } catch (Exception e) {
            System.err.println("Error al eliminar el dato: " + e.getMessage());
            return false;
        }
    }

    private String leerArchivo() throws Exception {
        File file = new File(URL + clazz.getSimpleName() + ".json");
        if (!file.exists()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try (FileReader fr = new FileReader(file)) {
            int ch;
            while ((ch = fr.read()) != -1) {
                sb.append((char) ch);
            }
        }
        return sb.toString();
    }

    private void escribirArchivo(String data) throws Exception {
        File dir = new File(URL);
        if (!dir.exists() && !dir.mkdirs()) {
            throw new Exception("No se pudo crear el directorio: " + URL);
        }
        try (FileWriter fw = new FileWriter(URL + clazz.getSimpleName() + ".json")) {
            fw.write(data);
        }
    }
}
