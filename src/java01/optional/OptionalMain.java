package java01.optional;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;

/**
 * Optional<T> 는 제네릭 타입으로 매번 if 문으로 null 인지 체크하는 대신 Optional 에 정의된 메소드를 통해서 간단하게 처리할 수 있다
 *
 *
 */
public class OptionalMain {

    public static void main(String[] args) {
        // TODO 1 초기화
        OptionalTestVO obj1 = new OptionalTestVO("안원빈", 35);
        Optional<OptionalTestVO> op1 = Optional.of(obj1);
        // null point exception
        Optional<OptionalTestVO> op2 = Optional.ofNullable(null);
//        Optional<OptionalTestVO> op3 = Optional.of(null);
        // null 초기화 보다는 empty 초기화가 바람직하다
        Optional<OptionalTestVO> op4 = Optional.<OptionalTestVO>empty();

        System.out.println(op1);
        System.out.println(op2);
        // null point exception
//        System.out.println(op3);
        System.out.println(op4);

        // TODO 2 객체의 값 가져오기
        Optional<String> optVal1 = Optional.of("abc");
        // Optional 에 저장된 값 반환, null 시 예외 발생
        Optional<String> optVal2 = Optional.ofNullable(null);
        String str1 = optVal1.get();
        // Optional 에 저장된 값 반환, null 시 예외 발생
//        String str2 = optVal2.get();
        // null 일 경우 "" 리턴
        String str3 = optVal2.orElse("");
        // null 일 경우 객체 생성 리턴
        String str4 = optVal2.orElseGet(String::new);
        // null 일 경우 Throw
//        String str5 = optVal2.orElseThrow(NullPointerException::new);
        System.out.println(str1);
//        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);


        // TODO 3 Optional 도 Stream 과 같이 filter(), map(), flatMap() 사용 가능
        int result1 = Optional.of("123")
                .filter(o -> o.length() > 0)
                .map(Integer::parseInt) // parseInt 는 예외가 발생하기 쉬운 메소드이므로 예외 처리된 메소드를 만든다
                .orElse(-1);
        System.out.println(result1);

        int result2 = Optional.of("")
                .filter(o -> o.length() > 0)
                .map(Integer::parseInt)
                .orElse(-1);
        System.out.println(result2);


        // TODO 4 isPresent() 는 Optional 객체의 값이 null 이면 false 를, 아니면 true 를 반환
        // ifPresent(Consumer<T>) 로 Consumer 객체로 출력 가능
        Optional<String> optPre1 = Optional.of("abc");
        Optional<String> optPre2 = Optional.ofNullable(null);

        if(optPre1.isPresent() == true){
            System.out.println("optPre1 not null");
        }
        // 간략 코드 변환
        // ifPresent(Consumer<T>)
        Optional.ofNullable("abc").ifPresent(System.out::println);

        if(optPre2.isPresent() == false){
            System.out.println("optPre2 null");
        }


        // TODO 5 ifPresent(Consumer<T>) 는 Optional<T> 를 반환하는 findAny(), findFirst() 와 같은 최종 연산과 잘 어울린다
        /*
         Stream 클래스에 정의된 메소드 중 Optional<T> 를 반환하는 메소드 목록
         Optional<T> findAny()
         Optional<T> findFirst()
         Optional<T> max(Consumer)
         Optional<T> min(Consumer)
         Optional<T> reduce(BinaryOperator<T>)
         */
        Stream.of("abc").findAny().ifPresent(System.out::println);


    }

    public static int optionalStringToInt(Optional<String> op, int defaultValue){
        try {
            return op.map(Integer::parseInt).get();
        }catch (Exception e){
            return defaultValue;
        }
    }

}
