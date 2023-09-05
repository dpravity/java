package java01.format;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.ParseException;

public class FormatMain {

    public static void main(String[] args) {
        decimalFormat();
        messageFormat();
        queryMessageFormat();
    }

    public static void decimalFormat() {
        System.out.println("===================");
        DecimalFormat df = new DecimalFormat("#,###.##");
        try {
            Number num = df.parse("1,234,567,89");
            System.out.println(num);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println("===================");
    }

    public static void messageFormat() {
        System.out.println("===================");
        String msg = "name : {0} \ntel: {1} \nage : {2}";
        Object[] args = {"안원빈", "010-Xxxx-xxxx", "3x"};
        String result = MessageFormat.format(msg, args);
        System.out.println(result);
        System.out.println("===================");
    }


    public static void queryMessageFormat() {
        System.out.println("===================");
        String tableName = "테이블";
        String msg = "insert into " + tableName + " values (''{0}'', ''{1}'', ''{2}'');";
        Object[] args = {"값1", "값2", "값3"};
        String result = MessageFormat.format(msg, args);
        System.out.println(result);
        System.out.println("===================");
    }


}
