package com.cemobile.framework.dao;

import com.cemobile.framework.entity.Classes;

public interface ClassMapper {
	
	Classes selectByPrimaryKey(Long classId);
	
}
