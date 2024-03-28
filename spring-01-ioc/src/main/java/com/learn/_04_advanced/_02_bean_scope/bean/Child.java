package com.learn._04_advanced._02_bean_scope.bean;

public class Child {
    private ToySingleton toySingleton;
    private ToyPrototype toyPrototype;

    public ToySingleton getToySingleton() {
        return toySingleton;
    }

    public void setToySingleton(ToySingleton toySingleton) {
        this.toySingleton = toySingleton;
    }

    public ToyPrototype getToyPrototype() {
        return toyPrototype;
    }

    public void setToyPrototype(ToyPrototype toyPrototype) {
        this.toyPrototype = toyPrototype;
    }

    @Override
    public String toString() {
        return "Child{" +
                "toySingleton=" + toySingleton +
                ",\n toyPrototype=" + toyPrototype +
                '}';
    }
}
