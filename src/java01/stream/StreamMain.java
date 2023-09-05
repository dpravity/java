package java01.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Collection, Iterator 와 같은 인터페이스를 이용해서 컬렉션을 다루는 방식을 표준화 했지만
 * 각 컬렉션 클래스에는 같은 기능의 메소드들이 중복해서 정의 되어있다
 * ex) Collections.sort(), Arrays.sort() 등
 *
 * 이런 문제점을 해결하기 위해 만들어진 것이 Stream 이다
 *
 * Stream 은 데이터 소스를 추상화 하고, 데이터를 다루는데 자주 사용되는 메소드들을 정의해 놓았다
 * 데이터 소스 추상화 = 데이터 소스가 무엇이든 같은 방식으로 다룰 수 있고, 코드의 재사용성이 높아진다
 *
 * 스트림은 데이터 소스를 변경하지 않는다
 * - 데이터를 읽기만 할 뿐, 데이터 소스를 변경하지 않는다
 * - 필요하다면 정렬된 결과를 컬렉션이나 배열에 담에서 반환할 수 있다
 * ex) stream.sorted().collect(Collectors.toList())
 *
 * 스트림은 일회용 이다
 * - 스트림은 Iterator 처럼 일회용이다
 * - 필요하다면 스트림을 다시 생성해야 한다
 *
 * 스트림은 작업을 내부 반복으로 처리한다
 * - 스트림을 이용한 작업이 간결한 이유는 내부 반복(반복문을 내부에 숨길 수 있다는 것을 의미) 이다
 * - forEach() 는 스트림에 정의된 메소드 중의 하나로 매개변수에 대입된 람다식을 데이터 소스의 모든 요소에 적용한다
 * ex) for(String str : strList){ System.out.println(str); }
 * ex) stream.forEach(System.out::println)
 *
 * 스트림의 연산
 * - 스트림이 제공하는 연산은 중간 연산, 최종 연산 으로 분류
 * 중간 연산 : 연산 결과가 스트림인 연산, 결과를 스트림으로 반환하기 때문에 중간 연산을 연속해서 연결할 수 있다
 * 최종 연산 : 연산 결과가 스트림이 아닌 연산, 스트림의 요소를 소모하므로 단 한번만 가능
 * ex) stream
 *      .distinct()   // 중간 연산
 *      .limit(5)   // 중간 연산
 *      .sorted()   // 중간 연산
 *      .forEach(System.out::println);  // 최종 연산
 *
 * 핵심 연산
 * 중간 연산은 map(), flatMap() 등
 * 최종 연산은 reduce(), collect(), forEach() 등
 *
 *
 * 지연된 연산
 * - 스트림 연산에서 중요한 점은 최종 연산이 수행되기 전까지 중간 연산이 수행되지 않는다
 * - 중간 연산을 호출하는 것은 어떤 작업이 수행되어야 하는지 지정해 주는 것
 * - 최종 연산이 수행되어야 스트림의 요소들이 중간 연산을 거쳐 최종 연산에서 소모된다
 *
 */
public class StreamMain {

    public static void main(String[] args) {
        String[] arr = {"dddd","a","fffff","bb","ccc","a"};

        Stream<String> stream = Stream.of(arr);                             // 문자열 배열이 소스인 스트림
        Stream<String> filterStream = stream.filter((i)-> i.length()>2);    // 필터 : 중간 연산
        Stream<String> distinctStream = filterStream.distinct();            // 중복제거 : 중간 연산
        Stream<String> sortStream = distinctStream.sorted();                // 정렬 : 중간 연산
        Stream<String> limitStream = sortStream.limit(5);           // 자르기 : 중간 연산
        long total = limitStream.count();                                   // 요소 개수 : 최종 연산


        List<String> list = Arrays.asList(arr);
        System.out.println("원본 : " + list.toString());
        List<String> list2 = list.stream()
                .filter(s->s.equals("a"))
                .collect(Collectors.toList());

        System.out.println("연산 : " + list.toString());
        System.out.println("복제 : " + list2.toString());



        List<MyClass> list3 = new ArrayList<>();
        list3.add(new MyClass("a"));
        list3.add(new MyClass("ccccc"));
        list3.add(new MyClass("bb"));
        list3.add(new MyClass("ddddddd"));
        list3.stream().forEach(o -> {
            o.setStr("0000");
            System.out.println(o.getStr());
        });

        list3.stream().forEach(o -> {
            System.out.println(o.getStr());
        });

    }

}

class MyClass {
    private String str;
    public MyClass(String str){
        this.str = str;
    }
    public void setStr(String str){
        this.str = str;
    }
    public String getStr(){
        return str;
    }
}
