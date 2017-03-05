package com.thinkgem.jeesite.modules.sql.entity;

import com.thinkgem.jeesite.common.persistence.BaseEntity;
import com.thinkgem.jeesite.common.persistence.Page;

/**
 * Created by free on 17-3-5.
 */
public class ModelWrap extends BaseEntity {


    private String limit ="";

    private String name;
    private String createSql;


    private SqlDatatable sqlDatatable;

    public SqlDatatable getSqlDatatable() {
        return sqlDatatable;
    }

    public void setSqlDatatable(SqlDatatable sqlDatatable) {
        this.sqlDatatable = sqlDatatable;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getCreateSql() {
        return createSql;
    }

    public void setCreateSql(String createSql) {
        this.createSql = createSql;
    }

    @Override
    public void preInsert() {
        
    }

    @Override
    public void preUpdate() {

    }

    public void preLimit(){

    }
}
