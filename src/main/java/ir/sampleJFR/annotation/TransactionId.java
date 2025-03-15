package ir.sampleJFR.annotation;


import jdk.jfr.Label;
import jdk.jfr.MetadataDefinition;
import jdk.jfr.Name;
import jdk.jfr.Relational;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@MetadataDefinition
@Name("com.oracle.TransactionId")
@Label("Transaction ID")
@Relational
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface TransactionId {
}
