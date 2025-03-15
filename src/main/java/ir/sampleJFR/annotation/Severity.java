package ir.sampleJFR.annotation;

import jdk.jfr.Description;
import jdk.jfr.Label;
import jdk.jfr.MetadataDefinition;
import jdk.jfr.Name;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@MetadataDefinition
@Name("com.oracle.Severity")
@Label("Severity")
@Description("Value between 0 and 100 that indicates " +
        "Severity. 100 is most severe.")
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface Severity {
    int value() default 50;
}
