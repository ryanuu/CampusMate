package com.cemobile.framework.dao;

import com.cemobile.framework.entity.Department;

public interface DepartmentMapper {
	
	Department selectByPrimaryKey(Long departmentId);
	
}
