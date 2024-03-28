package com.learn._04_advanced._01_factoryBean.bean;

public class Child {
    private String wantToy;

    public String getWantToy() {
        return wantToy;
    }

    public void setWantToy(String wantToy) {
        this.wantToy = wantToy;
    }

    @Override
    public String toString() {
        return "Child{" +
                "wantToy='" + wantToy + '\'' +
                '}';
    }
}
