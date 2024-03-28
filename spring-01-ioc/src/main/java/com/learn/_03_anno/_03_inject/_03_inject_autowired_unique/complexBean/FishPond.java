package com.learn._03_anno._03_inject._03_inject_autowired_unique.complexBean;

import com.learn._03_anno._03_inject._03_inject_autowired_unique.bean.Fish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FishPond {
    @Autowired
    private List<Fish> fishes;

    public List<Fish> getFishes() {
        return fishes;
    }

    public void setFishes(List<Fish> fishes) {
        this.fishes = fishes;
    }

    @Override
    public String toString() {
        return "FishPond{" +
                "fishes=" + fishes +
                '}';
    }
}
