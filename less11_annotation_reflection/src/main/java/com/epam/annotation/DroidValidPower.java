package com.epam.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.CONSTRUCTOR})
public @interface DroidValidPower {

    enum Priority {
        LOW(), MEDIUM(), HIGH();
    }

    Priority priority();
    String createdBy() default "epam.com";
    int value();
}
