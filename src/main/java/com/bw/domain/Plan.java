package com.bw.domain;

import java.math.BigDecimal;

public class Plan {
	
	private int id;
	private String name;
	private BigDecimal amount;
	private String manager;
	private String content;
	private int dept_id;
	private String deptName;
	public Plan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Plan(int id, String name, BigDecimal amount, String manager, String content, int dept_id, String deptName) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.manager = manager;
		this.content = content;
		this.dept_id = dept_id;
		this.deptName = deptName;
	}
	@Override
	public String toString() {
		return "Plan [id=" + id + ", name=" + name + ", amount=" + amount + ", manager=" + manager + ", content="
				+ content + ", dept_id=" + dept_id + ", deptName=" + deptName + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	

}
