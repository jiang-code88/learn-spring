package com.learn._02_xml._01_quickstart.dao;

import java.util.ArrayList;
import java.util.List;

public class JpaAccountDao {
    public List<String> accountNames;

    public List<String> getAccountNames(){
        accountNames = new ArrayList<>();
        accountNames.add("account=jack");
        accountNames.add("account=tom");
        accountNames.add("account=paul");
        return accountNames;
    }
}
