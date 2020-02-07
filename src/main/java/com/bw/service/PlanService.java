package com.bw.service;

import java.util.List;

import com.bw.domain.Department;
import com.bw.domain.Plan;
import com.github.pagehelper.PageInfo;

public interface PlanService {

	//添加投资数据
	void insertPlans(List<Plan> plans);
	//进行分页列表展示
	PageInfo<Plan> selects(Plan p, Integer page, Integer pageSize);
	//查询详情
	Plan planByid(Integer id);
	//下拉框
	List<Department> deptSelects();
	
	void update(Plan p);
	
	void delall(String ids);
	
	
	

}
