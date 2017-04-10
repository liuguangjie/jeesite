package com.xylj.order.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.xylj.order.entity.XTenementOrder;

/**
 * ddDAO接口
 * @author dd
 * @version 2017-04-04
 */
@MyBatisDao
public interface XTenementOrderDao extends CrudDao<XTenementOrder> {
	
}