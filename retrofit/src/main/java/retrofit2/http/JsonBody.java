package retrofit2.http;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * make json body
 * <p> ex,
 *
 * <pre><code>
 * `@JsonBody`
 * `Call<ResponseBody> sample(@JsonField("name") String name,@JsonField("age") int age);`
 *
 * body is
 *  {
 *    "name":"xx",
 *    "age":xx,
 *  }
 * </code></pre>
 * <p>
 * if no `JsonField`, body is `{}`
 *
 * @author yizems
 */
@Documented
@Target(METHOD)
@Retention(RUNTIME)
public @interface JsonBody {
}
