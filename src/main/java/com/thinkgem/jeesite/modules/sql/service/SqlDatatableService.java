/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sql.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.thinkgem.jeesite.modules.sql.entity.ModelWrap;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sql.entity.SqlDatatable;
import com.thinkgem.jeesite.modules.sql.dao.SqlDatatableDao;

import javax.sql.DataSource;

/**
 * 数据库表的操作Service
 * @author 刘光杰
 * @version 2017-03-04
 */
@Service
@Transactional(readOnly = true)
public class SqlDatatableService extends CrudService<SqlDatatableDao, SqlDatatable> implements ApplicationContextAware {

	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate;

	public List<Map<String, Object>> queryAllTables(ModelWrap wrap){
		List<Map<String, Object>> list=jdbcTemplate.queryForList(SQL.SELECT);
		return list;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		DataSource dataSource=applicationContext.getBean(DataSource.class);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.dataSource=dataSource;
	}


	public final JdbcTemplate getJdbcTemplate(){
		return this.jdbcTemplate;
	}

	public final DataSource getdataSource(){
		return this.dataSource;
	}

	@Transactional(readOnly = false)
	public void deleteTable(ModelWrap wrap) {
		jdbcTemplate.execute(" drop table " + wrap.getName());
	}

	@Transactional(readOnly = false)
	public void createTable(ModelWrap modelWrap) {
		jdbcTemplate.execute(modelWrap.getCreateSql());
	}
}