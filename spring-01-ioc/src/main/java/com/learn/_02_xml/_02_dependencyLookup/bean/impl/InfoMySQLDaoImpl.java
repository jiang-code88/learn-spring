package com.learn._02_xml._02_dependencyLookup.bean.impl;

public class InfoMySQLDaoImpl implements InfoDao{
    @Override
    public String findItem() {
        return "info";
    }
}
