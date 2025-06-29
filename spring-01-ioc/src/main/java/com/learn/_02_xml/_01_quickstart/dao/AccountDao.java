package com.learn._02_xml._01_quickstart.dao;

import java.util.ArrayList;
import java.util.List;

public class AccountDao {
    public List<String> getAccountNames(){
        List<String> accountNames = new ArrayList<>();
        accountNames.add("account=jack");
        accountNames.add("account=tom");
        accountNames.add("account=paul");
        return accountNames;
    }
}
