package com.learn._04_advanced._07_profile.datasource;

public class DataSource {
    private String name;

    public DataSource(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DataSource{" +
                "name='" + name + '\'' +
                '}';
    }
}
