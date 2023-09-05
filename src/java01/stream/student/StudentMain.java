package java01.stream.student;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

public class StudentMain {

    public static void main(String[] args) {
        Stream<Student> studentStream = Stream.of(
                new Student("안자바",1,300)
                ,new Student("이자바",3,500)
                ,new Student("조1자바",2,100)
                ,new Student("조2자바",2,200)
                ,new Student("강자바",4,700)
                ,new Student("힘자바",8,400)
        );


        studentStream.sorted(
                Comparator.comparing(Student::getBan)   // 반별 정렬
                        .thenComparing(Comparator.comparing(Student::getName).reversed())  // 이름 정렬, 부분 정렬
                        .thenComparing(Student::getTotalScore)   // 점수 정렬
                        .thenComparing(Comparator.naturalOrder())  // 기본 정렬
        ).forEach(System.out::println);



    }

}
