package java01.enums;

public class EnumMain {

    public static void main(String[] args) {
        System.out.println(EnumSample.EAST.getName());
        System.out.println(EnumSample.EAST.ordinal());

        for(EnumSample e : EnumSample.values()){
            System.out.println(e + " : " + e.getName());
        }
    }

}
