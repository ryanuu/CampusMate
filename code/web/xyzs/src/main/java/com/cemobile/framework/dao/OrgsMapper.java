package com.cemobile.framework.dao;

import java.util.List;

import com.cemobile.framework.entity.Org;

public interface OrgsMapper {

	List<Org> selectOrgAndAllSonOrgByOrg(Org org);
}
