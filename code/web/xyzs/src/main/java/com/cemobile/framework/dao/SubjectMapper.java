package com.cemobile.framework.dao;

import com.cemobile.framework.entity.Subject;

public interface SubjectMapper {
	
	Subject selectByPrimaryKey(Long subjectId);
}
