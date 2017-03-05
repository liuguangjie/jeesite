/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sql.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.sql.entity.ModelWrap;
import com.thinkgem.jeesite.modules.sql.entity.SqlDatatable;

/**
 * 数据库表的操作DAO接口
 * @author 刘光杰
 * @version 2017-03-04
 */
@MyBatisDao
public interface SqlDatatableDao extends CrudDao<SqlDatatable> {

    public Object queryAllTables(ModelWrap wrap);

}