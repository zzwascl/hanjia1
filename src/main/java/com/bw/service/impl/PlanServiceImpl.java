package com.bw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bw.dao.MapperDao;
import com.bw.domain.Department;
import com.bw.domain.Plan;
import com.bw.service.PlanService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yangchunbo.util.StringUtil;
@Service
public class PlanServiceImpl implements PlanService {
	@Autowired
	private MapperDao dao;

	@Override
	public void insertPlans(List<Plan> plans) {
		dao.insertPlans(plans);
		
	}

	@Override
	public PageInfo<Plan> selects(Plan p, Integer page, Integer pageSize) {
		// TODO Auto-generated method stub
		if(StringUtil.hasText(p.getName())) {
			System.out.println("关键词不为空");
		}else {
			System.out.println("关键词为空");
		}
		List<Plan> list=dao.selects(p);
		PageHelper.startPage(page, pageSize);
		return new PageInfo<>(list);
	}

	@Override
	public Plan planByid(Integer id) {
		// TODO Auto-generated method stub
		return dao.planByid(id);
	}

	@Override
	public List<Department> deptSelects() {
		// TODO Auto-generated method stub
		return dao.deptSelects();
	}

	@Override
	public void update(Plan p) {
		// TODO Auto-generated method stub
		dao.update(p);
	}

	@Override
	public void delall(String ids) {
		// TODO Auto-generated method stub
		dao.delall(ids);
	}

}
