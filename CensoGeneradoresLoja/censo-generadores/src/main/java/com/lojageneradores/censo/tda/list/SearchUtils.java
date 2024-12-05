package com.lojageneradores.censo.tda.list;

public class SearchUtils {

    public static <T> int sequentialSearch(T[] array, T key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(key)) {
                return i;
            }
        }
        return -1; 
    }

    public static <T extends Comparable<T>> int binarySearch(T[] array, T key) {
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid].compareTo(key) == 0) {
                return mid;
            }
            if (array[mid].compareTo(key) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; 
    }

    public static <T> int hashSearch(T[] array, T key, int hashSize) {
        int hashIndex = key.hashCode() % hashSize;
        if (hashIndex >= 0 && hashIndex < array.length && array[hashIndex] != null && array[hashIndex].equals(key)) {
            return hashIndex;
        }
        return -1;
    }
}
