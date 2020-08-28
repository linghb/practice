package com.itwrinkly.algorithm;

public class BitMap {

    public static void main(String[] args) {
        int[] arr = {10, 8, 3, 1, 2, 20, 15};
        byte[] bitmap = new byte[getIndex(20) + 1];
        for (int i = 0; i < arr.length; i++) {
            setBit(bitmap, arr[i]);
        }

        for (int idx = 0; idx < bitmap.length; idx++) {
            for (int pos = 0; pos < 8; pos++) {
                if ((bitmap[idx] & (0x01 << pos)) == (0x01 << pos)) {
                    int num = (idx << 3) | pos;
                    System.out.println("bit map sort:" + num);
                }
            }
        }
    }

    private static void setBit(byte[] bitmap, int num) {
        bitmap[getIndex(num)] |= (0x1 << getPos(num));
    }

    private static int getIndex(int num) {
        return num >>> 3;
    }

    private static int getPos(int num) {
        return num & 0x07;
    }

    private static boolean contains(byte[] bitmap, int num) {
        return (bitmap[getIndex(num)] & (0x1 << getPos(num))) != 0;
    }

    private static void clear(byte[] bitmap, int num) {
        bitmap[getIndex(num)] &= ~(0x1 << getPos(num));
    }
}
