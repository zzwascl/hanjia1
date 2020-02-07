package com.bw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.bw.domain.Department;
import com.bw.domain.Plan;

public interface MapperDao {

	void insertPlans(List<Plan> plans);

	//分页列表展示
	List<Plan> selects(Plan p);

	@Select("select a.*,b.`name` deptName FROM zhunneng_2019plan a\r\n" + 
			"LEFT JOIN zhunneng_department b on a.dept_id=b.id where a.id=#{id}")
	Plan planByid(Integer id);

	@Select("select * from zhunneng_department")
	List<Department> deptSelects();

	void update(Plan p);

	@Delete("delete from zhunneng_2019plan where id in(${ids})")
	void delall(@Param("ids")String ids);

}
