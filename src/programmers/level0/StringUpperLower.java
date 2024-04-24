package programmers.level0;

public class StringUpperLower {
    public static void main(String[] args) {
        String str = "aBcDeFg";
        int distance = 32;
        char[] chars = str.toCharArray();
        StringBuffer sb = new StringBuffer(str);
        for(int i = 0; i < chars.length; i++){
            if(Character.isUpperCase(chars[i])){
                sb.setCharAt(i, Character.toLowerCase((sb.charAt(i))));
            }else{
                sb.setCharAt(i, Character.toUpperCase((sb.charAt(i))));
            }
        }
        System.out.println(str);
        System.out.println(sb.toString());

        String a = "aaaaa";
        String b = "bbbbb";
        StringBuffer sb2 = new StringBuffer();
        for(int i = 0; i < a.length(); i++){
            sb2.append(a.charAt(i) + "" + b.charAt(i));
        }
        System.out.println(sb2.toString());
    }
}
