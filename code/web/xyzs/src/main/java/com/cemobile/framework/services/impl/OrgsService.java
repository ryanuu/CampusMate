package com.cemobile.framework.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cemobile.framework.common.page.Page;
import com.cemobile.framework.dao.ClassMapper;
import com.cemobile.framework.dao.DepartmentMapper;
import com.cemobile.framework.dao.LabClassMapper;
import com.cemobile.framework.dao.LabCollegeMapper;
import com.cemobile.framework.dao.LabDepartmentMapper;
import com.cemobile.framework.dao.LabSubjectMapper;
import com.cemobile.framework.dao.SubjectMapper;
import com.cemobile.framework.entity.Classes;
import com.cemobile.framework.entity.Department;
import com.cemobile.framework.entity.LabClass;
import com.cemobile.framework.entity.LabCollege;
import com.cemobile.framework.entity.LabDepartment;
import com.cemobile.framework.entity.LabSubject;
import com.cemobile.framework.entity.Org;
import com.cemobile.framework.entity.Orgtree;
import com.cemobile.framework.entity.Subject;
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
	@Autowired
	private DepartmentMapper departmentMapper;
	@Autowired
	private SubjectMapper subjectMapper;
	@Autowired
	private ClassMapper classMapper;
	
	@Override
	public int insert(Org org) {
		// TODO Auto-generated method stub
		int orgId=0;
		if(org.getLevel().equals("admin")){
			LabCollege labCollege=new LabCollege();
			labCollege.setCollegeName(org.getCollegeName());
			labCollege.setCollegeProfile(org.getCollegeProfile());
			labCollege.setShortName(org.getCollergeShortName());
			labCollege.setDel(0);
			orgId=labCollegeMapper.insert(labCollege);
		}
		else if(org.getLevel().equals("college")){
			LabDepartment labDepartment=new LabDepartment();
			labDepartment.setDepartmentName(org.getCollegeName());
			labDepartment.setCollegeId(org.getCollegeId());
			labDepartment.setDepartmentProfile(org.getCollegeProfile());
			labDepartment.setShortName(org.getCollergeShortName());
			labDepartment.setDel(0);
			orgId=labDepartmentMapper.insert(labDepartment);
		}
		else if(org.getLevel().equals("department")){
			LabSubject labSubject=new LabSubject();
			labSubject.setSubjectName(org.getCollegeName());
			labSubject.setDepartmentId(org.getCollegeId());
			labSubject.setSubjectProfile(org.getCollegeProfile());
			labSubject.setShortName(org.getCollergeShortName());
			labSubject.setDel(0);
			orgId=labSubjectMapper.insert(labSubject);
		}
		else if(org.getLevel().equals("subject")){
			LabClass labClass=new LabClass();
			labClass.setClassName(org.getClassName());
			labClass.setSubjectId(org.getSubjectId());
			labClass.setHeadmaster(org.getHeadmaster());
			labClass.setInstructor(org.getInstructor());
			labClass.setGrade(org.getGrade());
			labClass.setDel(0);
			orgId=labClassMapper.insert(labClass);
		}
		return orgId;
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
				labCollege.setCollegeId(org.getCollegeId());
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
		if(collegeList.size()>1){
			tree.setId(String.valueOf(0l));
			tree.setText("根组织");
			List<Orgtree> collegeTrees = new ArrayList<Orgtree>();
			for(LabCollege o:collegeList){
				Orgtree collegeTree = new Orgtree();
				collegeTree.setId(String.valueOf(o.getCollegeId()));
				collegeTree.setText(o.getCollegeName());
				collegeTree.setLevel("college");
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
									if(s.getDepartmentId().equals(d.getDepartmentId())){
										Orgtree subjectTree = new Orgtree();
										subjectTree.setId(String.valueOf(s.getSubjectId()));
										subjectTree.setText(s.getSubjectName());
										subjectTree.setLevel("subject");
										//班级
										List<Orgtree> classTrees = new ArrayList<Orgtree>();
										if(classList.size()!=0){
											for(LabClass c:classList){
												if(c.getSubjectId().equals(s.getSubjectId())){
													Orgtree classTree = new Orgtree();
													classTree.setId(String.valueOf(c.getClassId()));
													classTree.setText(c.getClassName());
													classTree.setLevel("class");
													classTrees.add(classTree);
												}
											}
										}
										subjectTree.setChildren(classTrees);
										subjectTrees.add(subjectTree);
									}
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
		else if(collegeList.size()==1){
			for(LabCollege o:collegeList){
				tree.setId(String.valueOf(o.getCollegeId()));
				tree.setText(o.getCollegeName());
				tree.setLevel("college");
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
									if(s.getDepartmentId().equals(d.getDepartmentId())){
										Orgtree subjectTree = new Orgtree();
										subjectTree.setId(String.valueOf(s.getSubjectId()));
										subjectTree.setText(s.getSubjectName());
										subjectTree.setLevel("subject");
										//班级
										List<Orgtree> classTrees = new ArrayList<Orgtree>();
										if(classList.size()!=0){
											for(LabClass c:classList){
												if(c.getSubjectId().equals(s.getSubjectId())){
													Orgtree classTree = new Orgtree();
													classTree.setId(String.valueOf(c.getClassId()));
													classTree.setText(c.getClassName());
													classTree.setLevel("class");
													classTrees.add(classTree);
												}
											}
										}
										subjectTree.setChildren(classTrees);
										subjectTrees.add(subjectTree);
									}
								}
							}
							departmentTree.setChildren(subjectTrees);
							departmentTrees.add(departmentTree);
						}
					}
					tree.setChildren(departmentTrees);
				}
			}
		}
		else{
			//学系
			if(departmentList.size()!=0){
				for (LabDepartment d : departmentList) {
					tree.setId(String.valueOf(d.getDepartmentId()));
					tree.setText(d.getDepartmentName());
					tree.setLevel("department");
					//专业
					List<Orgtree> subjectTrees = new ArrayList<Orgtree>();
					if(subjectList.size()!=0){
						for(LabSubject s:subjectList){
							if(s.getDepartmentId().equals(d.getDepartmentId())){
								Orgtree subjectTree = new Orgtree();
								subjectTree.setId(String.valueOf(s.getSubjectId()));
								subjectTree.setText(s.getSubjectName());
								subjectTree.setLevel("subject");
								//班级
								List<Orgtree> classTrees = new ArrayList<Orgtree>();
								if(classList.size()!=0){
									for(LabClass c:classList){
										if(c.getSubjectId().equals(s.getSubjectId())){
											Orgtree classTree = new Orgtree();
											classTree.setId(String.valueOf(c.getClassId()));
											classTree.setText(c.getClassName());
											classTree.setLevel("class");
											classTrees.add(classTree);
										}
									}
								}
								subjectTree.setChildren(classTrees);
								subjectTrees.add(subjectTree);
							}
						}
					}
					else{
						//班级
						if(classList.size()!=0){
							for(LabClass c:classList){
								if(c.getDepartmentId().equals(d.getDepartmentId())){
									Orgtree classTree = new Orgtree();
									classTree.setId(String.valueOf(c.getClassId()));
									classTree.setText(c.getClassName());
									classTree.setLevel("class");
									subjectTrees.add(classTree);
								}
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
								if(c.getSubjectId().equals(s.getSubjectId())){
									Orgtree classTree = new Orgtree();
									classTree.setId(String.valueOf(c.getClassId()));
									classTree.setText(c.getClassName());
									classTree.setLevel("class");
									classTrees.add(classTree);
								}
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
							tree.setText(c.getClassName());
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
	public List<Object> treeBygId(Orgtree orgTree) {
		// TODO Auto-generated method stub
		
		List<Object> list = new ArrayList<Object>();
		Org org =new Org(); 
		
		//判断是什么级别（学院、学系、专业、班级）
		if(orgTree.getLevel().equals("college")){
			LabCollege labCollege=new LabCollege();
			labCollege=labCollegeMapper.selectByPrimaryKey(Long.valueOf(orgTree.getId()));
			org.setCollegeId(labCollege.getCollegeId());
			org.setCollegeName(labCollege.getCollegeName());
			org.setCollegeProfile(labCollege.getCollegeProfile());
			org.setCollergeShortName(labCollege.getShortName());
			org.setLevel("college");
		}
		else if(orgTree.getLevel().equals("department")){
			Department labDepartment=new Department();
			labDepartment=departmentMapper.selectByPrimaryKey(Long.valueOf(orgTree.getId()));
			org.setDepartmentId(labDepartment.getDepartmentId());
			org.setDepartmentName(labDepartment.getDepartmentName());
			org.setDepartmentProfile(labDepartment.getDepartmentProfile());
			org.setDepartmentShortName(labDepartment.getShortName());
			org.setCollegeName(labDepartment.getCollegeName());
			org.setLevel("department");
		}
		else if(orgTree.getLevel().equals("subject")){
			Subject labSubject=new Subject();
			labSubject=subjectMapper.selectByPrimaryKey(Long.valueOf(orgTree.getId()));
			org.setSubjectId(labSubject.getSubjectId());
			org.setSubjectName(labSubject.getSubjectName());
			org.setSubjectProfile(labSubject.getSubjectProfile());
			org.setSubjectShortName(labSubject.getShortName());
			org.setDepartmentName(labSubject.getDepartmentName());
			org.setLevel("subject");
		}
		else if(orgTree.getLevel().equals("class")){
			Classes labClass=new Classes();
			labClass=classMapper.selectByPrimaryKey(Long.valueOf(orgTree.getId()));
			org.setClassId(labClass.getClassId());
			org.setClassName(labClass.getClassName());
			org.setHeadmaster(labClass.getHeadmaster());
			org.setInstructor(labClass.getInstructor());
			org.setHeadmasterName(labClass.getHeadmasterName());
			org.setInstructorName(labClass.getInstructorName());
			org.setSubjectName(labClass.getSubjectName());
			org.setLevel("class");
		}
		
		list.add(org);
		
		return list;
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

	@Override
	public int queryName(Org org) {
		// TODO Auto-generated method stub
		int count=0;
		if(org.getLevel().equals("admin")){
			LabCollege labCollege=new LabCollege();
			labCollege.setCollegeName(org.getCollegeName());
			List<LabCollege> collegeList=labCollegeMapper.queryByKeyword(labCollege);
			count=collegeList.size();
		}
		else if(org.getLevel().equals("college")){
			LabDepartment labDepartment=new LabDepartment();
			labDepartment.setDepartmentName(org.getCollegeName());
			labDepartment.setCollegeId(org.getCollegeId());
			List<LabDepartment> departmentList=labDepartmentMapper.queryByKeyword(labDepartment);
			count=departmentList.size();
		}
		else if(org.getLevel().equals("department")){
			LabSubject labSubject=new LabSubject();
			labSubject.setSubjectName(org.getCollegeName());
			labSubject.setDepartmentId(org.getCollegeId());
			List<LabSubject> subjectList=labSubjectMapper.queryByKeyword(labSubject);
			count=subjectList.size();
		}
		else if(org.getLevel().equals("subject")){
			LabClass labClass=new LabClass();
			labClass.setClassName(org.getClassName());
			labClass.setSubjectId(org.getSubjectId());
			labClass.setGrade(org.getGrade());
			List<LabClass> classList=labClassMapper.queryByKeyword(labClass);
			count=classList.size();
		}
		return count;
	}

}
