package java01.function;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionMain2 {

    public static void main(String[] args) {
        Function<String, Integer> f = s -> Integer.parseInt(s, 16);
        Function<Integer, String> g = i -> Integer.toBinaryString(i);
//        Function<Integer, String> g = Integer::toBinaryString;
        Function<String, String> h = f.andThen(g);
        Function<Integer, Integer> h2 = f.compose(g);

        System.out.println(h.apply("FF"));  // "FF" -> 255 -> "11111111"
        System.out.println(h2.apply(2));    // 2 -> "10" -> 16

        Function<String, String> f2 = x -> x;   // 항등 함수 (identity function)
        System.out.println(f2.apply("AAA"));    // AAA 그대로 출력 (항등 함수)

        Predicate<Integer> p = i -> i < 100;
        Predicate<Integer> q = i -> i < 200;
        Predicate<Integer> r = i -> i % 2 == 0;
        Predicate<Integer> notP = p.negate();   // i >= 100

        Predicate<Integer> all = notP.and(q).or(r);
        System.out.println(all.test(150));  // true

        String str1 = "abc";
        String str2 = "abc";

        // str1 과 str2 가 같은지 비교한 결과 반환
        Predicate<String> p2 = Predicate.isEqual(str1);
        boolean result = p2.test(str2);
        System.out.println("str1 과 str2 가 같은지 비교한 결과 반환 : " + result);

        BiFunction<Integer,String,Test> m = (i, str) -> new Test(i, str);
        BiFunction<Integer,String,Test> m2 = Test::new;

    }

}

class Test{
    private int a;
    private String str;
    public Test(int a, String str){
        this.a=a;
        this.str=str;
    }
}
