package java01.lang;

import java.util.StringJoiner;
import java.util.StringTokenizer;

public class StringMain {

    public static void main(String[] args) {
        String str = "string";

        StringBuffer sbf = new StringBuffer("string buffer");
        sbf.append(" test buffer");
        System.out.println(sbf);


        // mutil thread 멀티스레드에 안전
        StringBuilder sb = new StringBuilder("string builder");
        sb.append(" test builder");
        System.out.println(sb);

        StringJoiner sj = new StringJoiner(",");
        sj.add("string");
        sj.add("joiner");
        System.out.println(sj);


        // 긴 문자열을 지정된 구분자를 기준으로 토큰 이라는 여러 개의 문자열로 잘라내는데 사용
        String source = "100,200,300,400";
        StringTokenizer st = new StringTokenizer(source, ",");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

        System.out.println("--------------------");

        String product = "상품1,1000,900,800|상품2,2000,1900,1800";
        StringTokenizer st2 = new StringTokenizer(product, "|");
        while (st2.hasMoreTokens()) {
            String token = st2.nextToken();

            StringTokenizer st3 = new StringTokenizer(token, ",");

            while (st3.hasMoreTokens()){
                System.out.println(st3.nextToken());
            }
            System.out.println("--------------------");


        }

    }

}
