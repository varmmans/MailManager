package ec.com.hananeel.mailmanager.qualifier;

import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.TYPE;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target({ TYPE })
@Documented
@Indexed
public @interface Component {
    //@AliasFor(annotation = Stateless.class)
    String value() default "";
}
