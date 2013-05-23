package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 21.05.13
 * Time: 13:37
 * To change this template use File | Settings | File Templates.
 */

/**
 * Annotation @TextValue can annotate only fields of simple classes (long, int, short, byte, double, float, char) and
 * java.lang.String.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface TextValue {
    String value() default "";
}
