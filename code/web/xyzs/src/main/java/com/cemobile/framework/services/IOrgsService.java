package com.cemobile.framework.services;

import java.util.List;

import com.cemobile.framework.common.page.Page;
import com.cemobile.framework.entity.Org;
import com.cemobile.framework.entity.Orgtree;

public interface IOrgsService {
	
	//添加组织
    public int insert(Org org);
    //修改组织
	public int update(Org org);
	//根据orgId删除组织
	public void deleteByOrgId(String orgId);
	//条件查询组织
	public List<Org> query(Org org, Page page);
	//tree组织
	public List<Orgtree> treelist(Org org);
	//根据orgId 获取组织数据
	public List<Object>  treeBygId(Orgtree orgTree);

	Org queryOrg(Long orgId);
	
	List<Org> queryOrgAndAllSonOrg(Org org);

}
