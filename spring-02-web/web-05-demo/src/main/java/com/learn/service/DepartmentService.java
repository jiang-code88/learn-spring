package com.learn.service;

import com.learn.dao.DepartmentDao;
import com.learn.emtity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentDao departmentDao;

    public void save(Department department) {
        departmentDao.save(department);
    }

    public void deleteById(String id) {
        departmentDao.deleteById(id);
    }

    public List<Department> findDepartmentsByName(String name) {
        Department query = new Department();
        query.setName(name);
        return departmentDao.findDepartments(query);
    }

    public List<Department> findDepartments(Department query) {
        if (query == null) {
            return departmentDao.findAllDepartments();
        }
        return departmentDao.findDepartments(query);
    }

    public Department findById(String id) {
        return departmentDao.findById(id);
    }
}

