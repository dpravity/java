package java01.optional;

import java.util.Optional;
import java.util.OptionalInt;

public class OptionalIntMain {

    public static void main(String[] args) {
        OptionalInt op1 = OptionalInt.of(0);
        OptionalInt op2 = OptionalInt.empty();

        System.out.println(op1.isPresent());    // true
        System.out.println(op2.isPresent());    // false

        System.out.println(op1.getAsInt());
        // nullpointexception 예외 발생
//        System.out.println(op2.getAsInt());

        System.out.println(op1.equals(op2));    // false

        // TODO 1 Optional 객체의 경우 null 을 저장하면 비어있는 것과 동일 취급
        Optional<String> ops1 = Optional.ofNullable(null);
        Optional<String> ops2 = Optional.empty();
        System.out.println(ops1.equals(ops2));  // true



    }

}
