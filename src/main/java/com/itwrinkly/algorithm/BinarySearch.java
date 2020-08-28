package com.itwrinkly.algorithm;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3};
        int targetIndex = binarySearch(arr, 2);
        System.out.println("bina:" + targetIndex);
    }

    private static int binarySearch(int[] arr, int target) {
        int left = 0; int right = arr.length -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    private static int leftBound(int[] arr, int target) {
        int left = 0; int right = arr.length -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            }
        }

        if (left >= arr.length || arr[left] != target) return  -1;
        return left;
    }

    private static int rightBound(int[] arr, int target) {
        int left = 0; int right = arr.length -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            }
        }

        if (right < 0 || arr[right] != target) return  -1;
        return right;
    }
}
