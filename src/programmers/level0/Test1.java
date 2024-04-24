package programmers.level0;

public class Test1 {
    public static void main(String[] args) {
        int num1 = 100;
        int num2 = 1;
//        System.out.println(num1 ^ num2);
//        System.out.println(~num1 & num2);
//        System.out.println((~num1 & num2) << 1);
//        System.out.println(sub(num1, num2));
        int a = 5;
        System.out.println(a);
        System.out.println(a>>1);
        System.out.println(a>>2);
        System.out.println(a>>3);
        System.out.println(bytesToBinaryString((byte)a));
        byte b = (byte)( a >> 1);
        byte b2 = (byte)( b >> 1);
        byte b3 = (byte)( b2 >> 1);
        System.out.println(bytesToBinaryString(b));
        System.out.println(bytesToBinaryString(b2));
        System.out.println(bytesToBinaryString(b3));
        System.out.println(Integer.toBinaryString(a));
    }

    public static int sub(int num1, int num2) {
        return num2 == 0 ? num1 : sub(num1 ^ num2, (~num1 & num2) << 1);
    }

    public static String bytesToBinaryString(Byte b) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            builder.append(((0x80 >>> i) & b) == 0 ? '0' : '1');
        }

        return builder.toString();
    }
}
