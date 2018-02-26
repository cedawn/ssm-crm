package com.gch.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gch.common.utils.Page;
import com.gch.crm.pojo.BaseDict;
import com.gch.crm.pojo.Customer;
import com.gch.crm.pojo.QueryVo;
import com.gch.crm.service.BaseDictService;
import com.gch.crm.service.BaseDictServiceImp;
import com.gch.crm.service.CustomerService;

/**
 * 
 * @author Administrator
 *
 */

@Controller
public class CustomerController {
	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private CustomerService customerSerivce;
	
	@Value("${fromType.code}")
	private String formTypeCode;
	@Value("${industryType.code}")
	private String industryTypeCode;
	@Value("${levelType.code}")
	private String levelTypeCode;
	
	
	@RequestMapping(value="/customer/list.action")
	public String list(QueryVo vo,Model model){
		List<BaseDict> fromType = baseDictService.selectBaseDictByCode(formTypeCode);
		List<BaseDict> industryType =baseDictService.selectBaseDictByCode(industryTypeCode);
		List<BaseDict> levelType =baseDictService.selectBaseDictByCode(levelTypeCode);
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType",levelType);
		
		Page<Customer> page = customerSerivce.selectPageByQueryVo(vo);
		model.addAttribute("page", page);
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		return "customer";
	}
	@RequestMapping(value="/customer/edit.action")
	public @ResponseBody
	Customer edit(Integer id){
		return customerSerivce.selectCustomerByCustId(id);
	}
	
	@RequestMapping(value="/customer/update.action")
	public @ResponseBody
	void update(Customer customer){
		customerSerivce.updateCustomerByCustId(customer);
	}
	@RequestMapping(value="/customer/delete.action")
	public @ResponseBody
	void delete(Integer id){
		customerSerivce.deleteCustomerByCustId(id);
	}
}
