package com.learn._04_advanced._09_advance_componentScan.filterComponentScan.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME) // 表示在运行时生效
@Target(ElementType.TYPE)
public @interface Animals {
}
