package java01.stream;

import java01.stream.student.Student;

import java.io.File;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMain3 {

    public static void main(String[] args) {
        // TODO 1. map() 스트림 요소에 저장된 값 중에서 원하는 필드만 추출, 특정 형태로 변환
        map();

        // TODO 2. peek() * 조회 * 연산과 연산 사이에 올바르게 처리되었는지 확인하고 싶을 경우 peek() 사용
        peek();

        // TODO 3. mapToObj() IntStream -> Stream<String> 으로 변환
        mapToObj();

        // TODO 4. summaryStatistics 통계
        summaryStatistics();
    }

    // TODO 1. map() 스트림 요소에 저장된 값 중에서 원하는 필드만 추출, 특정 형태로 변환
    public static void map(){
        Stream<Student> studentStream = Stream.of(
                new Student("안자바",1,300)
                ,new Student("이자바",3,500)
                ,new Student("조1자바",2,100)
                ,new Student("조2자바",2,200)
                ,new Student("강자바",4,700)
                ,new Student("힘자바",8,400)
        );

        studentStream.map(student -> student.getBan()).forEach(System.out::println);
    }

    // TODO 2. peek() * 조회 * 연산과 연산 사이에 올바르게 처리되었는지 확인하고 싶을 경우 peek() 사용
    public static void peek(){
        // Stream<File> -> Stream<String>
        Stream<File> fileStream = Stream.of(new File("ex1.java"), new File("ex2.java"), new File("ex3.java"));
        Stream<String> changeStream = fileStream.map(File::getName);
        changeStream
                .filter(s -> s.indexOf(".") != -1)
                .peek(s -> System.out.println("PEEK #### filename : " + s))
                .map(s -> s.substring(s.indexOf(".") + 1))
                .peek(s -> System.out.println("PEEK #### substring : " + s))
                .map(String::toUpperCase)
                .peek(s -> System.out.println("PEEK #### toUpperCase : " + s))
                .distinct()
                .forEach(System.out::println);

    }

    /**
     * 로또 사자
     */
    // TODO 3. mapToObj() IntStream -> Stream<String> 으로 변환
    public static void mapToObj(){
        IntStream intStream = new Random().ints(1, 45);
        Stream<String> lottoStream = intStream.distinct().limit(6).sorted()
                .mapToObj(i -> i + " ");    // 정수를 문자열로 리턴
        lottoStream.forEach(System.out::println);
    }

    // TODO 4. summaryStatistics 통계
    public static void summaryStatistics(){
        Student[] arr = {
                new Student("안자바",1,300)
                ,new Student("이자바",3,500)
                ,new Student("조1자바",2,100)
                ,new Student("조2자바",2,200)
                ,new Student("강자바",4,700)
                ,new Student("힘자바",8,400)
        };

        Stream<Student> studentStream1 = Stream.of(arr);
        Stream<Student> studentStream2 = Stream.of(arr);
        Stream<Student> studentStream3 = Stream.of(arr);

        IntStream scoreStream1 = studentStream1.mapToInt(Student::getTotalScore);
        long totalScore = scoreStream1.sum();
        System.out.println("totalScore : " + totalScore);

        IntStream scoreStream2 = studentStream2.mapToInt(Student::getTotalScore);
        OptionalDouble avg = scoreStream2.average();
        System.out.println("average : " + avg.getAsDouble());

        IntStream scoreStream3 = studentStream3.mapToInt(Student::getTotalScore);
        // DoubleSummaryStatistics, LongSummaryStatistics
        IntSummaryStatistics statistics = scoreStream3.summaryStatistics();

        long totalCount = statistics.getCount();
        long totalScore2 = statistics.getSum();
        double avgScore = statistics.getAverage();
        int minScore = statistics.getMin();
        int maxScore = statistics.getMax();
        System.out.println("totalCount = " + totalCount);
        System.out.println("totalScore2 = " + totalScore2);
        System.out.println("avgScore = " + avgScore);
        System.out.println("minScore = " + minScore);
        System.out.println("maxScore = " + maxScore);
    }


}
