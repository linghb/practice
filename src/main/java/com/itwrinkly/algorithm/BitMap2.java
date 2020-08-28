package com.itwrinkly.algorithm;

public class BitMap2 {

    public static void main(String[] args) {
        int[] arr = {10, 8, 3, 1, 2, 20, 15, 3, 2, 10, 2};
        byte[] bitmap = new byte[getIndex(20) + 1];

        for (int i = 0; i < arr.length; i++) {
            int sum = getSum(bitmap, arr[i]);
            if (sum <= 1) {
                setBitAndSum(bitmap, arr[i], sum + 1);
            }
        }

        for (int idx = 0; idx < bitmap.length; idx++) {
            for (int pos = 0; pos < 4; pos++) {
                int num = (idx << 2) | (pos & 0x03);
                int sum = getSum(bitmap, num);
                if (sum > 0)
                    System.out.println("num:" + num + ", count:" + sum);
            }
        }

    }

    private static int getIndex(int num) {
        return num >>> 2;
    }

    private static int getPos(int num) {
        return num & 0x03;
    }

    private static void setBitAndSum(byte[] bitmap, int num, int sum) {
        int idx = num >> 2;
        int pos = num & 0x03;
        bitmap[idx] &= ~(0x03 << 2 * pos);
        bitmap[idx] |= ((sum & 0x03) << 2 * pos);
    }

    private static int getSum(byte[] bitmap, int num) {
        int idx = num >> 2;
        int pos = num & 0x03;
        return (bitmap[idx] & (0x03 << 2 * pos)) >> 2 * pos;
    }
}
