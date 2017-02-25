package com.epam.java.se.task7;

import java.lang.annotation.*;

/**
 * Created by Мария on 25.02.2017.
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SubmarineAnnotation {
    String type();
    String location();
}