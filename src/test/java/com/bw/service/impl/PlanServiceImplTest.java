package com.bw.service.impl;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bw.domain.Plan;
import com.bw.service.PlanService;
import com.yangchunbo.util.NumberUtil;
import com.yangchunbo.util.StreamUtil;
import com.yangchunbo.util.StringUtil;
@ContextConfiguration(locations="classpath:spring-beans.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class PlanServiceImplTest {
	@Autowired
	private PlanService service;

	@Test
	public void test() {
		//创建一个list集合存储对象
		List<Plan> Plans=new ArrayList<>();
		//调用工具类
		//可以创建一个file文件，读取file文件
		List<String> list = StreamUtil.readLine(this.getClass().getResourceAsStream("/data.txt"));
		for (String str : list) {
			Plan p=new Plan();
			String[] s = str.split("\\==");
			if(StringUtil.hasText(s[0])) {
				p.setName(s[0]);
			}
			if(StringUtil.hasText(s[1])&&NumberUtil.isNumber(s[1])) {
				p.setAmount(new BigDecimal(s[1]));
			}
			if(StringUtil.hasText(s[2])) {
				p.setContent(s[2]);
			}
			if(StringUtil.hasText(s[3])) {
				p.setManager(s[3]);
			}
			//最好用数据库查询id方法
			if(StringUtil.hasText(s[4])) {
				if(s[4].equals("炸药厂")) {
					p.setDept_id(1);
				}
				if(s[4].equals("生产服务中心")) {
					p.setDept_id(2);
				}
				if(s[4].equals("洗选车间")) {
					p.setDept_id(3);
				}
				if(s[4].equals("准能选煤厂")) {
					p.setDept_id(4);
				}
				if(s[4].equals("矸电公司")) {
					p.setDept_id(5);
				}
				if(s[4].equals("大准铁路公司")) {
					p.setDept_id(6);
				}
			}
			Plans.add(p);			
		}
		service.insertPlans(Plans);
		
	}

}
