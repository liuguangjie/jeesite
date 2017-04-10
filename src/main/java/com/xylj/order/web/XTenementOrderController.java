package com.xylj.order.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.xylj.order.entity.XTenementOrder;
import com.xylj.order.service.XTenementOrderService;

/**
 * ddController
 * @author dd
 * @version 2017-04-04
 */
@Controller
@RequestMapping(value = "/order/xTenementOrder")
public class XTenementOrderController extends BaseController {

	@Autowired
	private XTenementOrderService xTenementOrderService;
	
	@ModelAttribute
	public XTenementOrder get(@RequestParam(required=false) String id) {
		XTenementOrder entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = xTenementOrderService.get(id);
		}
		if (entity == null){
			entity = new XTenementOrder();
		}
		return entity;
	}
	
	@RequestMapping(value = "/list")
	public String list(XTenementOrder xTenementOrder, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<XTenementOrder> page = xTenementOrderService.findPage(new Page<XTenementOrder>(request, response), xTenementOrder); 
		model.addAttribute("page", page);
		return "xylj/order/xTenementOrderList";
	}

	@RequestMapping(value = "/form")
	public String form(XTenementOrder xTenementOrder, Model model) {
		model.addAttribute("xTenementOrder", xTenementOrder);
		return "xylj/order/xTenementOrderForm";
	}

	@RequestMapping(value = "/save")
	public String save(XTenementOrder xTenementOrder, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, xTenementOrder)){
			return form(xTenementOrder, model);
		}
		xTenementOrderService.save(xTenementOrder);
		return "redirect:"+Global.getAdminPath()+"/order/xTenementOrder/?repage";
	}
	
	@RequestMapping(value = "/delete")
	public String delete(XTenementOrder xTenementOrder, RedirectAttributes redirectAttributes) {
		xTenementOrderService.delete(xTenementOrder);
		return "redirect:"+Global.getAdminPath()+"/order/xTenementOrder/?repage";
	}

}