package java01.annotation;

import java.lang.annotation.*;

@Inherited
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ElapsedTime {
    long startTime = System.currentTimeMillis();
    long endTime = System.currentTimeMillis();

}
