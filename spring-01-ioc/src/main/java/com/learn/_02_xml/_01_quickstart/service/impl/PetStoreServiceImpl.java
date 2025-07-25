package com.learn._02_xml._01_quickstart.service.impl;

import com.learn._02_xml._01_quickstart.dao.AccountDao;
import com.learn._02_xml._01_quickstart.dao.ItemDao;
import com.learn._02_xml._01_quickstart.service.PetStoreService;

import java.util.List;


public class PetStoreServiceImpl implements PetStoreService {
    public AccountDao accountDao;
    public ItemDao itemDao;

    @Override
    public List<String> getUsernameList() {
        return accountDao.getAccountNames();
    }

    @Override
    public List<String> getItemNameList() {
        return itemDao.getItemNames();
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setItemDao(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public ItemDao getItemDao() {
        return itemDao;
    }
}
