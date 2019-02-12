package com.gmail.vyacheslavxxxxx;

public class Binary {
    /*
     * 3.6 Двоичное обратное представление числа* Написать программу
     * инвертированного двоичного представления числа так (в обратном порядке, слева
     * – младшие биты, а справа – старшие).
     */
    public byte[] intToBinaryWithoutZero(int n) {
        byte[] s = new byte[6];

        for (int i = 0; n > 0; i++) {

            if (i == s.length) {
                s = this.correctArrayByteSize(s, 0, s.length + 1, s.length);
            }
            byte newByte = (byte) ((n % 2) == 0 ? 0 : 1);
            s[i] = newByte;
            n = n / 2;
        }
        s = removeZeros(s);
        reverseArray(s);

        return s;
    }

    private void reverseArray(byte s[]) {
        for (int i = 0; i < s.length / 2; i++) {
            byte temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }
    }

    private byte[] removeZeros(byte[] s) {
        int startPostitionNewArray = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == 0) {
                startPostitionNewArray++;
            } else {
                break;
            }
        }
        s = this.correctArrayByteSize(s, startPostitionNewArray, s.length - startPostitionNewArray,
                s.length - startPostitionNewArray);
        return s;
    }

    private byte[] correctArrayByteSize(byte[] array, int startPosition, int length, int rangeToCopy) {
        byte[] newArray = new byte[length];

        System.arraycopy(array, startPosition, newArray, 0, rangeToCopy);

        return newArray;

    }

    public byte[] intToBinaryReverse(int number) {
        int b;
        byte[] s = new byte[6];
        for (int i = 0; number != 0; i++) {
            if (i == s.length) {
                s = this.correctArrayByteSize(s, 0, s.length + 1, s.length);
            }
            b = number % 2;
            s[i] = (byte) b;
            number = number / 2;
        }
        return s;
    }

    public static void main(String[] args) {
        Binary binary = new Binary();
        for (byte b : binary.intToBinaryWithoutZero(100)) {
            System.out.print(b);
        }
        System.out.println();
        for (byte b : binary.intToBinaryReverse(100)) {
            System.out.print(b);
        }
    }
}
