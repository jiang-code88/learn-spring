package com.learn._02_xml._03_dependencyInject.bean;

/**
 * 电影
 *   - 包含 Director 类
 */
public class Movie {
    private String name;
    private int number;
    private Director director;
    private String var;

    public Movie() {
    }

    public Movie(String name, int number, Director director) {
        this.name = name;
        this.number = number;
        this.director = director;
    }

    public Movie(String name, Director director) {
        this.name = name;
        this.director = director;
    }

    public Movie(Director director, String var) {
        this.director = director;
        this.var = var;
    }

    public Movie(int number, Director director) {
        this.number = number;
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", director=" + director +
                ", var='" + var + '\'' +
                '}';
    }
}
