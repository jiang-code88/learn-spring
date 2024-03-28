package com.learn._04_advanced._08_conditional.customConditional.anno;

import com.learn._04_advanced._08_conditional.customConditional.condition.OnBeanCondition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Conditional(OnBeanCondition.class)
public @interface ConditionalOnBean {
    Class<?>[] beans() default {};
}
