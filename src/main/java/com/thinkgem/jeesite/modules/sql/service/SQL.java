package com.thinkgem.jeesite.modules.sql.service;

/**
 * Created by free on 17-3-5.
 */
public class SQL {

    public static final String SELECT = "SELECT t.table_name AS name,t.TABLE_COMMENT AS comments FROM information_schema.`TABLES` t WHERE t.TABLE_SCHEMA = (select database()) ORDER BY t.TABLE_NAME";
    public static final String ALERT = "";
    public static final String CREATE = "";


}
