package parsing;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 18.05.13
 * Time: 21:54
 * To change this template use File | Settings | File Templates.
 */
@Retention(RetentionPolicy.RUNTIME)

public @interface SetValue {
    String className() default "Class.class";
    String firstName() default "";
    String lastName() default "";
    int age() default 0;
    String addressCity() default "";
    String addressCountry() default "";
    String addressAddress() default "";
    boolean married() default false;
    String profession()default "";
    double salary() default 0;
    int children() default 0;
    String birthdayYear() default "";
    String birthdayMonth() default "";
    String birthdayDay() default "";
    String birthday() default "1980, 00, 01";
    String speciality() default "";
    Gender gender() default Gender.Male;

}
