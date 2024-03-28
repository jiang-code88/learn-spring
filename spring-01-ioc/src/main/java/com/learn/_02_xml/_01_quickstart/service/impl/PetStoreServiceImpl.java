package com.learn._02_xml._01_quickstart.service.impl;

import com.learn._02_xml._01_quickstart.service.PetStoreService;
import com.learn._02_xml._01_quickstart.dao.JpaAccountDao;
import com.learn._02_xml._01_quickstart.dao.JpaItemDao;

import java.util.List;

public class PetStoreServiceImpl implements PetStoreService {

    public JpaAccountDao accountDao;
    public JpaItemDao itemDao;


    @Override
    public List<String> getUsernameList() {
        return accountDao.getAccountNames();
    }

    @Override
    public List<String> getItemNameList() {
        return itemDao.getItemNames();
    }

    public void setAccountDao(JpaAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setItemDao(JpaItemDao itemDao) {
        this.itemDao = itemDao;
    }
}
