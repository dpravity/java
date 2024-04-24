package programmers.level0;

public class StringOverwrite {
    public static void main(String[] args) {
        String my_string = "He11oWor1d";
        String overwrite_string = "lloWorl";
        int s = 2;
        StringBuffer sb = new StringBuffer(my_string);
        sb.replace(s,overwrite_string.length() + s, overwrite_string);
        System.out.println(sb.toString());

        String prefix = my_string.substring(0, s);
        String suffix = my_string.substring(s + overwrite_string.length());

        System.out.println(prefix + overwrite_string + suffix);
    }
}
