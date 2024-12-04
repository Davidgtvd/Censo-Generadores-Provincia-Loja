package com.lojageneradores.censo.dao.implement;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lojageneradores.censo.tda.list.LinkedList;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Method;

public class AdapterDao<T> implements IntefazDao<T> {
    private final Class<T> clazz;
    private final Gson gson;
    public static final String URL = "media/";

    public AdapterDao(Class<T> clazz) {
        this.clazz = clazz;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public T get(Integer id) throws Exception {
        LinkedList<T> list = listAll();
        if (!list.isEmpty()) {
            for (T item : list.toArray()) {
                if (getId(item).equals(id)) {
                    return item;
                }
            }
        }
        return null;
    }

    private Integer getId(T obj) {
        try {
            Method method = null;
            for (Method m : clazz.getMethods()) {
                if (m.getName().equalsIgnoreCase("getId")) {
                    method = m;
                    break;
                }
            }
            if (method == null) {
                for (Method m : clazz.getSuperclass().getMethods()) {
                    if (m.getName().equalsIgnoreCase("getId")) {
                        method = m;
                        break;
                    }
                }
            }
            if (method != null) {
                return (Integer) method.invoke(obj);
            }
        } catch (Exception e) {
            System.err.println("Error al obtener el ID: " + e.getMessage());
        }
        return -1;
    }

    @Override
    public LinkedList<T> listAll() {
        LinkedList<T> list = new LinkedList<>();
        try {
            String data = readFile();
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
    public void merge(T object, Integer index) throws Exception {
        LinkedList<T> list = listAll();
        list.update(object, index);
        saveFile(gson.toJson(list.toArray()));
    }

    @Override
    public void persist(T object) throws Exception {
        LinkedList<T> list = listAll();
        list.add(object);
        saveFile(gson.toJson(list.toArray()));
    }

    private String readFile() throws Exception {
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

    private void saveFile(String data) throws Exception {
        File dir = new File(URL);
        if (!dir.exists() && !dir.mkdirs()) {
            throw new Exception("No se pudo crear el directorio: " + URL);
        }
        try (FileWriter fw = new FileWriter(URL + clazz.getSimpleName() + ".json")) {
            fw.write(data);
        }
    }
}
