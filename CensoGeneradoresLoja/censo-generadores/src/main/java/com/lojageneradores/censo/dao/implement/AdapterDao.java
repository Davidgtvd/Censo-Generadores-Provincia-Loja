package com.lojageneradores.dao.implement;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lojageneradores.dao.InterfazDao;
import com.lojageneradores.tda.list.LinkedList;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Method;

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
            Method method = null;
            for (Method m : clazz.getMethods()) {
                if (m.getName().equalsIgnoreCase("getId")) {
                    method = m;
                    break;
                }
            }
            if (method != null) {
                return (K) method.invoke(obj);
            }
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
                T[] items = gson.fromJson(data, (Class<T[]>) java.lang.reflect.Array.newInstance(clazz, 0).getClass());
                list.toList(items);
            }
        } catch (Exception e) {
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
            list.removeIf(item -> id.equals(getId(item)));
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
