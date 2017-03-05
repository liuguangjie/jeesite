/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sql.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thinkgem.jeesite.modules.sql.entity.ModelWrap;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
import com.thinkgem.jeesite.modules.sql.entity.SqlDatatable;
import com.thinkgem.jeesite.modules.sql.service.SqlDatatableService;

import java.util.List;
import java.util.Map;

/**
 * 数据库表的操作Controller
 * @author 刘光杰
 * @version 2017-03-04
 */
@Controller
@RequestMapping(value = "${adminPath}/sql/datatable")
public class SqlDatatableController extends BaseController {

	@Autowired
	private SqlDatatableService sqlService;

	@RequiresPermissions("sql:datatable:query")
	@RequestMapping(value = {"/queryList", ""})
	public String list(ModelWrap modelWrap,HttpServletRequest request, HttpServletResponse response, Model model) {
		Page page=new Page(request,response);
		modelWrap.setPage(page);

		List<Map<String, Object>> rowList= sqlService.queryAllTables(modelWrap);
		model.addAttribute("rowList",rowList);
		model.addAttribute("page",page);
		return "modules/sql/sqlDatatableList";
	}

	@RequiresPermissions("sql:datatable:query")
	@RequestMapping(value = "/form")
	public String form(ModelWrap modelWrap, Model model) {
		model.addAttribute("sqlDatatable", modelWrap);
		return "modules/sql/sqlDatatableForm";
	}

	@RequiresPermissions("sql:datatable:add")
	@RequestMapping(value = "/addTable")
	public String save(ModelWrap modelWrap, Model model, RedirectAttributes redirectAttributes) {

		// sqlService
		sqlService.createTable(modelWrap);

		addMessage(redirectAttributes, "创建表&rdquo;成功");
		return "redirect:"+Global.getAdminPath()+"/sql/datatable/?repage";
	}
	
	@RequiresPermissions("sql:datatable:del")
	@RequestMapping(value = "/delTable")
	public String delete(ModelWrap modelWrap, RedirectAttributes redirectAttributes) {
		this.sqlService.deleteTable(modelWrap);
		addMessage(redirectAttributes, "删除表"+modelWrap.getName()+"&rdquo;成功成功");
		return "redirect:"+Global.getAdminPath()+"/sql/datatable/?repage";
	}

}