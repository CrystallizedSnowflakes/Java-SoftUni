package a04createAnnotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // Where the annotation is applicable
// - CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE-class
@Retention(RetentionPolicy.RUNTIME) // When annotation is applicable - SOURCE, CLASS, RUNTIME
public @interface Subject {
    String[] categories() default {};
}
