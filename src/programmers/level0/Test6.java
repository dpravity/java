package programmers.level0;

import java.util.stream.IntStream;

public class Test6 {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(t1(n));
        System.out.println(t2(n));
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(n >> 1));
        System.out.println(Integer.toBinaryString(0x01));
        System.out.println(n >> 0x01);
        System.out.println(((n >> 0x01) + 0x01));
    }
    public static int t1(int n){
        return (n>>0x01) * ((n>>0x01) + 0x01);
    }
    public static int t2(int n){
        return IntStream.rangeClosed(1, n).filter(value -> value % 2 == 0).sum();
    }
}
