package com.learn._03_anno._02_componentScan.bean;

import com.learn._03_anno._01_BeanDependencyLookupAndInject.bean.Item;
import com.learn._03_anno._01_BeanDependencyLookupAndInject.bean.Person;
import org.springframework.stereotype.Component;

// @Component() // 默认 beanName 为 "类名的首字母小写"
@Component("infoBean") // 指定 beanName 为 “infoBean”
public class Info {
    private String name;
    private int num;
    private Item item;
    private Person person;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Info{" +
                "name='" + name + '\'' +
                ", num=" + num +
                ", item=" + item +
                ", person=" + person +
                '}';
    }
}
