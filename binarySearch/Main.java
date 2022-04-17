package com.company.algorithms.binarySearch;

import java.util.Arrays;

public class Main {
    static int someFunc(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;
        int index = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] < key || arr[mid] == key) {
                left = mid + 1;
            } else if (arr[mid] > key) {
                index = mid;
                break;
            }
            }
        int[] someArr = Arrays.copyOfRange(arr, index, arr.length);
        return someArr.length;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 4};
        int key = 1;
        int x = someFunc(arr, key);
        System.out.println(x);
    }

}

