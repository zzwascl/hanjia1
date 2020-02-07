package com.bw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.stat.TableStat.Mode;
import com.bw.domain.Department;
import com.bw.domain.Plan;
import com.bw.service.PlanService;
import com.github.pagehelper.PageInfo;

@Controller
public class PlanController {
	@Autowired
	private PlanService service;
	
	//分页展示列表
	@RequestMapping("list")
	public String  selects(Plan p,Model model,@RequestParam(defaultValue="1")Integer page,@RequestParam(defaultValue="5")Integer pageSize) {
		PageInfo<Plan> info=service.selects(p,page,pageSize);
		model.addAttribute("info",info);
		model.addAttribute("p",p);
		return "list";
	}
	
	//查询详情
	@ResponseBody
	@RequestMapping("planByid")
	public Plan planByid(Integer id) {
		System.out.println(service.planByid(id));
		return service.planByid(id);
	}
	
	@RequestMapping("toupdate")
	public String  toupdate(Integer id,Model model) {
		System.out.println(service.planByid(id));
		Plan p= service.planByid(id);
		model.addAttribute("p",p);
		System.out.println(p);
		return "update";		
	}
	
	@RequestMapping("deptSelects")
	@ResponseBody
	public List<Department> deptSelects(){
		return service.deptSelects();
	}
	
	//修改
	@RequestMapping("update")
	public String update(Plan p) {
		service.update(p);
		return "redirect:list";
	}
	
	//批量删除
	@RequestMapping("delall")
	public String delall(String ids) {
		System.out.println(ids);
		service.delall(ids);
		return "redirect:list";
	}
	

}
