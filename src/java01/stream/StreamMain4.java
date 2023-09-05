package java01.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @see java.util.stream.Collector
 * Supplier supplier() : 작업 결과를 저장할 공간을 제공
 * BiConsumer<A, T> accumulator() : 스트림의 요소를 어떻게 수집(collect) 할 방법을 제공
 * BinaryOperator<A> combiner() : 두 저장공간을 병합할 방법을 제공(병렬 스트림)
 * Function<T, R> finisher() : 결과를 최종적으로 변환할 방법을 제공
 * Set<Characteristics> characteristics() : 컬렉터가 수행하는 작업의 속성에 대한 정보를 제공
 */
public class StreamMain4 {

    public static void main(String[] args) {
        String[] arr = {"a","bb","ccc"};
        StringBuffer sb = new StringBuffer();   // supplier(), 저장할 공간을 생성

        for(String str : arr){
            sb.append(str);
        }

        String result = sb.toString();  // finisher(), StringBuffer 를 String 으로 변환

        List<String> list = Arrays.asList(arr);
        List<String> list2 = list.stream()
                .filter(o -> o.equals("a"))
                .collect(Collectors.toList());
    }

}
