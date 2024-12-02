package com.lojageneradores.censo.dao.implement;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lojageneradores.censo.tda.list.LinkedList;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Method;

public class AdapterDao<T> implements IntefazDao<T> {
    private Class clazz;
    private Gson gson;
    public static String URL = "media/";

    public AdapterDao(Class clazz) {
        this.clazz = clazz;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public T get(Integer id) throws Exception {
        LinkedList<T> list = listAll();
        if (!list.isEmpty()) {
            T[] items = list.toArray();
            for (T item : items) {
                if (getId(item).intValue() == id.intValue()) {
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
            return -1; // Devuelve -1 si ocurre algún error
        }
        return -1;
    }

    @Override
    public LinkedList<T> listAll() {
        LinkedList<T> list = new LinkedList<>();
        try {
            String data = readFile();
            if (data != null && !data.isEmpty()) {
                T[] items = (T[]) gson.fromJson(data, java.lang.reflect.Array.newInstance(clazz, 0).getClass());
                list.toList(items);
            }
        } catch (Exception e) {
            System.out.println("Error al leer los datos: " + e.getMessage());
        }
        return list;
    }

    @Override
    public void merge(T object, Integer index) throws Exception {
        LinkedList<T> list = listAll();
        list.update(object, index);
        String json = gson.toJson(list.toArray());
        saveFile(json);
    }

    @Override
    public void persist(T object) throws Exception {
        LinkedList<T> list = listAll();
        list.add(object);
        String json = gson.toJson(list.toArray());
        saveFile(json);
    }

    private String readFile() throws Exception {
        StringBuilder sb = new StringBuilder();
        try (FileReader fr = new FileReader(URL + clazz.getSimpleName() + ".json")) {
            int ch;
            while ((ch = fr.read()) != -1) {
                sb.append((char) ch);
            }
        }
        return sb.toString();
    }

    private void saveFile(String data) throws Exception {
        try (FileWriter fw = new FileWriter(URL + clazz.getSimpleName() + ".json")) {
            fw.write(data);
        }
    }
}
