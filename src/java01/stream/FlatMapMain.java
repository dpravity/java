package java01.stream;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 스트림의 요소가 배열이거나 map()의 연산 결과가 배열인 경우 = Stream<T[]>
 * Stream<T[]> 인 경우 Stream<T> 로 다루는 것이 더 편리할 때가 있다
 * 이럴때는 map() 대신 flatMap() 을 사용하면 된다
 */
public class FlatMapMain {

    public static void main(String[] args) {
        Stream<String[]> strArrStream1 = Stream.of(
                new String[]{"abc", "def", "ghi"}
                , new String[]{"ABC", "DEF", "GHI"}
        );

        /**
         * Stream<String[]> 을 map(Arrays::stream) 으로 변환한 결과는 Stream<Stream<String>> 이다
         * String[] -> Stream<String>
         */
        Stream<Stream<String>> strStream = strArrStream1.map(Arrays::stream);
        strStream.forEach(System.out::println);

        System.out.println("=====================================");

        Stream<String[]> strArrStream2 = Stream.of(
                new String[]{"abc", "def", "ghi"}
                , new String[]{"ABC", "DEF", "GHI"}
        );
        /**
         * Stream<String> 으로 만들려면 flatMap(Arrays::stream)
         * 변환한 결과는 Stream<String> 이다
         * String[] -> String
         */
        Stream<String> strFlatMapStream = strArrStream2.flatMap(Arrays::stream);
        strFlatMapStream.forEach(System.out::println);
    }

}
