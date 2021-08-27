package retrofit2.http;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @author yizems
 * @see JsonBody
 */
@Documented
@Target(PARAMETER)
@Retention(RUNTIME)
public @interface JsonField {
  String value();
}
