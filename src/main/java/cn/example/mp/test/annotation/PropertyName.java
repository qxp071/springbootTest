package cn.example.mp.test.annotation;

import java.lang.annotation.*;

/**
 * @author hp
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PropertyName {
    String value() default "";
}
