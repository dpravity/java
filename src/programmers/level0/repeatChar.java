package programmers.level0;

public class repeatChar {
    public static void main(String[] args) {
        String my_string = "hello";
        int n = 3;
        t2(my_string, n);
    }

    public static void t1(String my_string, int n){
        char[] chars = my_string.toCharArray();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < chars.length; i++){
            for(int j = 0; j < n; j++){
                sb.append(chars[i]);
            }
        }
        System.out.println(sb.toString());
    }
    public static void t2(String my_string, int n){
        char[] chars = my_string.toCharArray();
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < chars.length; i++){
            sb.append((chars[i] + "").repeat(n));
        }
        System.out.println(sb.toString());
    }
}
