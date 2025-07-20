package com.learn._02_xml._03_dependencyInject;

import com.learn._02_xml._03_dependencyInject.bean.Complex;
import com.learn._02_xml._03_dependencyInject.bean.Director;
import com.learn._02_xml._03_dependencyInject.bean.Movie;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DependencyInjectApplication {
    public static int i = 1;
    public static String commentText = "========%s========%n";

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "_02_xml/_03_dependencyInject/dependencyInject.xml");

        // 1 setter 方法注入
        System.out.printf(commentText, i++);
        Movie movie = context.getBean("movie", Movie.class);
        System.out.println(movie);

        Director director = context.getBean("director", Director.class);
        System.out.println(director);
        System.out.println();

        // 2 构造器方法注入
        System.out.printf(commentText, i++);
        Movie movieA = context.getBean("movieA", Movie.class);
        System.out.println("movieA：" + movieA);

        Movie movieB = context.getBean("movieB", Movie.class);
        System.out.println("movieB：" + movieB);

        Movie movieC = context.getBean("movieC", Movie.class);
        System.out.println("movieC：" +movieC);
        System.out.println();

        // 3 复杂的容器属性的依赖注入
        System.out.printf(commentText, i++);
        Complex bean = context.getBean(Complex.class);
        System.out.println(bean);
    }
}
