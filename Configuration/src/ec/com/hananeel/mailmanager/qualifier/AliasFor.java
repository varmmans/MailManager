package ec.com.hananeel.mailmanager.qualifier;

import java.lang.annotation.Annotation;
import static java.lang.annotation.ElementType.METHOD;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

@Retention(RUNTIME)
@Target({ METHOD })
@Qualifier
public @interface AliasFor {
    /**
     * Alias for {@link #attribute}.
     * <p>Intended to be used instead of {@link #attribute} when {@link #annotation}
     * is not declared &mdash; for example: {@code @AliasFor("value")} instead of
     * {@code @AliasFor(attribute = "value")}.
     */
    @AliasFor("attribute")
    String value() default "";

    /**
     * The name of the attribute that <em>this</em> attribute is an alias for.
     * @see #value
     */
    @AliasFor("value")
    String attribute() default "";

    /**
     * The type of annotation in which the aliased {@link #attribute} is declared.
     * <p>Defaults to {@link Annotation}, implying that the aliased attribute is
     * declared in the same annotation as <em>this</em> attribute.
     */
    Class<? extends Annotation> annotation() default Annotation.class;
}
