package other;

import javax.persistence.Entity;
import java.lang.annotation.Inherited;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 29.04.13
 * Time: 18:26
 * To change this template use File | Settings | File Templates.
 */
@Inherited
public @interface AnnotationTest {
    int count() default 100;
    String name();
}
