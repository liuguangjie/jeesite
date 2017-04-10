package com.xylj.order.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.xylj.order.entity.XTenementOrder;
import com.xylj.order.dao.XTenementOrderDao;

/**
 * ddService
 * @author dd
 * @version 2017-04-04
 */
@Service
@Transactional(readOnly = true)
public class XTenementOrderService extends CrudService<XTenementOrderDao, XTenementOrder> {

	public XTenementOrder get(String id) {
		return super.get(id);
	}
	
	public List<XTenementOrder> findList(XTenementOrder xTenementOrder) {
		return super.findList(xTenementOrder);
	}
	
	public Page<XTenementOrder> findPage(Page<XTenementOrder> page, XTenementOrder xTenementOrder) {
		return super.findPage(page, xTenementOrder);
	}
	
	@Transactional(readOnly = false)
	public void save(XTenementOrder xTenementOrder) {
		super.save(xTenementOrder);
	}
	
	@Transactional(readOnly = false)
	public void delete(XTenementOrder xTenementOrder) {
		super.delete(xTenementOrder);
	}
	
}