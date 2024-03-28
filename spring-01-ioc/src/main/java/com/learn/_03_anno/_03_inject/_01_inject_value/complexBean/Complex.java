package com.learn._03_anno._03_inject._01_inject_value.complexBean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Component
public class Complex {
    @Value("#{new String[] {'张三', '李四'}}")
    private String[] names;

    @Value("#{{'333333', '3333', '33'}}")
    private List<String> tels;

    // 引用现有的Bean，以及创建新的Bean
    @Value("#{{element, new com.learn._03_anno._03_inject._01_inject_value.complexBean.Element()}}")
    private Set<Element> cats;

    @Value("#{{'喵喵': element.toString(), '猫猫': new com.learn._03_anno._03_inject._01_inject_value.complexBean.Element().toString()}}")
    private Map<String, Object> events;

    @Value("#{{'123': '牵着手', '456': '抬起头', '789': '我们私奔到月球'}}")
    private Properties props;

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
