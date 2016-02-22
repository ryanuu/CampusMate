package com.cemobile.framework.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cemobile.framework.common.page.Page;
import com.cemobile.framework.dao.LabClassMapper;
import com.cemobile.framework.dao.LabCollegeMapper;
import com.cemobile.framework.dao.LabDepartmentMapper;
import com.cemobile.framework.dao.LabSubjectMapper;
import com.cemobile.framework.entity.LabClass;
import com.cemobile.framework.entity.LabCollege;
import com.cemobile.framework.entity.LabDepartment;
import com.cemobile.framework.entity.LabSubject;
import com.cemobile.framework.entity.Org;
import com.cemobile.framework.entity.Orgtree;
import com.cemobile.framework.services.IOrgsService;

@Service
@Transactional
public class OrgsService implements IOrgsService {
	
	@Autowired
	private LabCollegeMapper labCollegeMapper;
	@Autowired
	private LabDepartmentMapper labDepartmentMapper;
	@Autowired
	private LabSubjectMapper labSubjectMapper;
	@Autowired
	private LabClassMapper labClassMapper;
	
	@Override
	public int insert(Org org) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Org org) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteByOrgId(String orgId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Org> query(Org org, Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orgtree> treelist(Org org) {
		// TODO Auto-generated method stub
		//查询学院
		LabCollege labCollege=new LabCollege();
		List<LabCollege> collegeList=new ArrayList<LabCollege>();
		if(org.getCollegeId()!=null) 
		{
			if(org.getCollegeId()!=0)
			{
				labCollege.setCollegeId(org.getClassId());
			}
			collegeList=labCollegeMapper.queryByKeyword(labCollege);	
		}
		
		//查询系
		LabDepartment labDepartment=new LabDepartment();
		List<LabDepartment> departmentList=new ArrayList<LabDepartment>();
		if(collegeList.size()!=0){
			for(int i=0;i<collegeList.size();i++){
				labDepartment.setCollegeId(collegeList.get(i).getCollegeId());
				departmentList.addAll(labDepartmentMapper.queryByKeyword(labDepartment));
			}
		}
		else{
			labDepartment.setDepartmentId(org.getDepartmentId());
			departmentList=labDepartmentMapper.queryByKeyword(labDepartment);
		}
		
		//查询专业
		LabSubject labSubject=new LabSubject();
		List<LabSubject> subjectList=new ArrayList<LabSubject>();
		if(departmentList.size()!=0){
			for(int i=0;i<departmentList.size();i++){
				labSubject.setDepartmentId(departmentList.get(i).getDepartmentId());
				subjectList.addAll(labSubjectMapper.queryByKeyword(labSubject));
			}
		}
		else{
			labSubject.setDepartmentId(org.getDepartmentId());
			subjectList=labSubjectMapper.queryByKeyword(labSubject);
		}
		
		//查询班级
		LabClass labClass=new LabClass();
		List<LabClass> classList=new ArrayList<LabClass>();
		if(subjectList.size()!=0){
			for(int i=0;i<subjectList.size();i++){
				labClass.setSubjectId(subjectList.get(i).getSubjectId());
				classList.addAll(labClassMapper.queryByKeyword(labClass));
			}
		}
		else{
			labClass.setSubjectId(org.getSubjectId());
			classList=labClassMapper.queryByKeyword(labClass);
		}
			
		Orgtree tree = new Orgtree();
		
		//组成tree
		if(collegeList.size()!=0){
			tree.setId(String.valueOf(0l));
			tree.setText("根组织");
			List<Orgtree> collegeTrees = new ArrayList<Orgtree>();
			for(LabCollege o:collegeList){
				Orgtree collegeTree = new Orgtree();
				collegeTree.setId(String.valueOf(o.getCollegeId()));
				collegeTree.setText(o.getCollegeName());
				collegeTree.setLevel("collegeTree");
				//学系
				if(departmentList.size()!=0){
					List<Orgtree> departmentTrees = new ArrayList<Orgtree>();
					for (LabDepartment d : departmentList) {
						if (d.getCollegeId().equals(o.getCollegeId())) {
							Orgtree departmentTree = new Orgtree();
							departmentTree.setId(String.valueOf(d.getDepartmentId()));
							departmentTree.setText(d.getDepartmentName());
							departmentTree.setLevel("department");
							//专业
							List<Orgtree> subjectTrees = new ArrayList<Orgtree>();
							if(subjectList.size()!=0){
								for(LabSubject s:subjectList){
									Orgtree subjectTree = new Orgtree();
									subjectTree.setId(String.valueOf(s.getSubjectId()));
									subjectTree.setText(s.getSubjectName());
									subjectTree.setLevel("subject");
									//班级
									List<Orgtree> classTrees = new ArrayList<Orgtree>();
									if(classList.size()!=0){
										for(LabClass c:classList){
											Orgtree classTree = new Orgtree();
											classTree.setId(String.valueOf(c.getClassId()));
											classTree.setText(c.getCalssName());
											classTree.setLevel("class");
											classTrees.add(classTree);
										}
									}
									subjectTree.setChildren(classTrees);
									subjectTrees.add(subjectTree);
								}
							}
							departmentTree.setChildren(subjectTrees);
							departmentTrees.add(departmentTree);
						}
					}
					collegeTree.setChildren(departmentTrees);
					collegeTrees.add(collegeTree);
				}
			}
			tree.setChildren(collegeTrees);
		}
		else{
			//学系
			if(departmentList.size()!=0){
				for (LabDepartment d : departmentList) {
					tree.setId(String.valueOf(d.getDepartmentId()));
					tree.setText(d.getDepartmentName());
					tree.setLevel("departmen");
					//专业
					List<Orgtree> subjectTrees = new ArrayList<Orgtree>();
					if(subjectList.size()!=0){
						for(LabSubject s:subjectList){
							Orgtree subjectTree = new Orgtree();
							subjectTree.setId(String.valueOf(s.getSubjectId()));
							subjectTree.setText(s.getSubjectName());
							subjectTree.setLevel("subject");
							//班级
							List<Orgtree> classTrees = new ArrayList<Orgtree>();
							if(classList.size()!=0){
								for(LabClass c:classList){
									Orgtree classTree = new Orgtree();
									classTree.setId(String.valueOf(c.getClassId()));
									classTree.setText(c.getCalssName());
									classTree.setLevel("class");
									classTrees.add(classTree);
								}
							}
							subjectTree.setChildren(classTrees);
							subjectTrees.add(subjectTree);
						}
					}
					else{
						//班级
						if(classList.size()!=0){
							for(LabClass c:classList){
								Orgtree classTree = new Orgtree();
								classTree.setId(String.valueOf(c.getClassId()));
								classTree.setText(c.getCalssName());
								classTree.setLevel("class");
								subjectTrees.add(classTree);
							}
						}
					}
					tree.setChildren(subjectTrees);
				}
			}
			else{
				//专业
				if(subjectList.size()!=0){
					for(LabSubject s:subjectList){
						tree.setId(String.valueOf(s.getSubjectId()));
						tree.setText(s.getSubjectName());
						tree.setLevel("subject");
						//班级
						List<Orgtree> classTrees = new ArrayList<Orgtree>();
						if(classList.size()!=0){
							for(LabClass c:classList){
								Orgtree classTree = new Orgtree();
								classTree.setId(String.valueOf(c.getClassId()));
								classTree.setText(c.getCalssName());
								classTree.setLevel("class");
								classTrees.add(classTree);
							}
						}
						tree.setChildren(classTrees);
					}
				}
				else{
					//班级
					if(classList.size()!=0){
						for(LabClass c:classList){
							tree.setId(String.valueOf(c.getClassId()));
							tree.setText(c.getCalssName());
							tree.setLevel("class");
						}
					}
				}
			}
		}
		
		List<Orgtree> trees = new ArrayList<Orgtree>();
		trees.add(tree);
		return trees;
	}
	

	@Override
	public List<Object> treeBygId(Long orgId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Org queryOrg(Long orgId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Org> queryOrgAndAllSonOrg(Org org) {
		// TODO Auto-generated method stub
		
		return null;
	}

}
