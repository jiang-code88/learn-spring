package com.learn.dao;

import com.learn.emtity.Department;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DepartmentDao {

    public int save(Department department) {
        System.out.println("save department: " + department.toString());
        return 1;
    }

    public int deleteById(String id) {
        System.out.println("delete department by id: " + id);
        return 1;
    }

    public List<Department> findAllDepartments() {
        ArrayList<Department> departments = new ArrayList<>();
        departments.add(new Department("01", "IT-ALL", "95563"));
        departments.add(new Department("02", "HR-ALL", "97865"));
        return departments;
    }

    public List<Department> findDepartments(Department query) {
        System.out.println("query department: " + query);
        ArrayList<Department> departments = new ArrayList<>();
        departments.add(new Department("03", "CEO-FIND-BY-DEPT", "95533"));
        return departments;
    }

    public Department findById(String id) {
        System.out.println("query department by id: " + id);
        return new Department("04", "QA-FIND-BY-ID", "95533");
    }
}
