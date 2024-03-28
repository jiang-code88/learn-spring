package com.learn._02_xml._03_dependencyInject.bean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Complex {
    private String[] names;
    private List<String> tels;
    private Set<Element> cats;
    private Map<String, Object> events;
    private Properties props;

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public List<String> getTels() {
        return tels;
    }

    public void setTels(List<String> tels) {
        this.tels = tels;
    }

    public Set<Element> getCats() {
        return cats;
    }

    public void setCats(Set<Element> cats) {
        this.cats = cats;
    }

    public Map<String, Object> getEvents() {
        return events;
    }

    public void setEvents(Map<String, Object> events) {
        this.events = events;
    }

    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    @Override
    public String toString() {
        return "Complex{" +
                "\nnames=" + Arrays.toString(names) +
                ", \ntels=" + tels +
                ", \ncats=" + cats +
                ", \nevents=" + events +
                ", \nprops=" + props +
                '}';
    }
}
