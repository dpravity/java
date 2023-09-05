package java01.stream;


import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Collection 최상위 클래스에 stream() 이 정의되어 있다
 * Stream<T> Collection.stream();
 * Collection 의 자손은 stream() 생성 가능
 */
public class StreamMain2 {

    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> list = Arrays.asList(1,3,2,4,10,6,9,8,7,5);
        Stream<Integer> stream = list.stream();
//      list.stream().forEach(System.out::println);
        list.stream().sorted();
        System.out.println(list);


//        ToIntFunction<Integer> tif = i -> i;
//        IntStream intStream = stream.mapToInt(tif);
//        System.out.println(intStream.sum());
//
//        // end 미포함
//        IntStream intStream1 = IntStream.range(1, 10);
//        System.out.println(intStream1.sum());
//
//        // end 포함
//        IntStream intStream2 = IntStream.rangeClosed(1, 10);
//        System.out.println(intStream2.sum());



    }

}
