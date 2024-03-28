package com.learn._02_xml._02_dependencyLookup.bean.impl;

import java.util.Arrays;
import java.util.List;

public class DemoOracleDaoImpl implements DemoDao {
    @Override
    public List<String> findAll() {
        return Arrays.asList("oracle", "oracle", "oracle");
    }
}
