package com.learn._02_xml._01_quickstart.dao;

import java.util.ArrayList;
import java.util.List;

public class ItemDao {
    public List<String> itemNames;

    public List<String> getItemNames(){
        itemNames = new ArrayList<>();
        itemNames.add("item=apple");
        itemNames.add("item=banana");
        itemNames.add("item=orange");
        return itemNames;
    }
}
