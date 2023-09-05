package java01.lang;

public class HashMain {

    public static void main(String[] args) throws InterruptedException {
        String str = "test";

        System.out.println(str.hashCode());
        System.out.println(System.identityHashCode(str));

        System.out.println(str.getClass().getName() + "@" + str.hashCode());
        System.out.println(str.getClass().getName() + "@" + Integer.toHexString(str.hashCode()));
    }

}
