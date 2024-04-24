package programmers.level0;

public class DescSort {
    public static void main(String[] args) {
        charArray2();
    }
    public static void intArray(){
        int[] array = {1, 0, 1, 1, 1, 3, 5};
        int[] temp = new int[array.length];
        for(int i = array.length - 1, j = 0; i >= 0; i--, j++){
            temp[j] = array[i];
        }
    }
    public static void charArray(){
        String my_string = "jaron";
        char[] chars = my_string.toCharArray();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < chars.length; i++){
            sb.append(chars[chars.length - i - 1]);
        }
        System.out.println(sb.toString());
    }
    public static void charArray2(){
        String my_string = "jaron";
        StringBuffer sb = new StringBuffer(my_string);
        System.out.println(sb.reverse());
    }
}
