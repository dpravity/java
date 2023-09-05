package java01.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringJoiner;

/**
 * Collection Framework : 자바의 자료구조
 * - List
 * - Set
 * - Map
 */
public class SetMain {

    private static final int DEFAULT_CAPACITY = 10;
    public static final int SOFT_MAX_ARRAY_LENGTH = Integer.MAX_VALUE - 8;
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    public static Object[] elementData = new Object[DEFAULT_CAPACITY];


    public static void main(String[] args) {
//        int a = 1;
//        int b = 1 << 2;
//        int c = 1 << 4;
//        System.out.println("1 : " + bytesToBinaryString((byte) a));
//        System.out.println("1 << 2 : " + bytesToBinaryString((byte) b));
//        System.out.println("1 << 4 : " + bytesToBinaryString((byte) c));

        grow(11);

    }

    public static void print(){

    }

    public static String bytesToBinaryString(Byte b) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            builder.append(((0x80 >>> i) & b) == 0 ? '0' : '1');
        }

        return builder.toString();
    }

    private static Object[] grow(int minCapacity) {
        int oldCapacity = 10;
        if (oldCapacity > 0 || elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            int newCapacity = newLength(oldCapacity,
                    minCapacity - oldCapacity, /* minimum growth */
                    oldCapacity >> 1           /* preferred growth */);
            return elementData = Arrays.copyOf(elementData, newCapacity);
        } else {
            return elementData = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
        }
    }
    public static int newLength(int oldLength, int minGrowth, int prefGrowth) {
        // preconditions not checked because of inlining
        // assert oldLength >= 0
        // assert minGrowth > 0

        int prefLength = oldLength + Math.max(minGrowth, prefGrowth); // might overflow
        if (0 < prefLength && prefLength <= SOFT_MAX_ARRAY_LENGTH) {
            return prefLength;
        } else {
            // put code cold in a separate method
            return hugeLength(oldLength, minGrowth);
        }
    }

    private static int hugeLength(int oldLength, int minGrowth) {
        int minLength = oldLength + minGrowth;
        if (minLength < 0) { // overflow
            throw new OutOfMemoryError(
                    "Required array length " + oldLength + " + " + minGrowth + " is too large");
        } else if (minLength <= SOFT_MAX_ARRAY_LENGTH) {
            return SOFT_MAX_ARRAY_LENGTH;
        } else {
            return minLength;
        }
    }
}
