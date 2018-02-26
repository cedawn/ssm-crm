package com.gch.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gch.common.utils.Page;
import com.gch.crm.mapper.CustomerDao;
import com.gch.crm.pojo.Customer;
import com.gch.crm.pojo.QueryVo;

@Service
public class CustomerServiceImp implements CustomerService {
	@Autowired
	private CustomerDao customerDao;

	public Page<Customer> selectPageByQueryVo(QueryVo vo){
		Page<Customer> page = new Page<Customer>();
		page.setSize(5);
		vo.setSize(5);
		if(null!= vo){
			if(null!=vo.getPage()){
				page.setPage(vo.getPage());
				vo.setStartRow((vo.getPage()-1)*vo.getSize());
			}if(null !=vo.getCustName() && !"".equals(vo.getCustName().trim())){
				vo.setCustName(vo.getCustName().trim());
			}if(null != vo.getCustSource() && !"".equals(vo.getCustSource().trim())){
				vo.setCustSource(vo.getCustSource().trim());
			}
			if(null != vo.getCustIndustry() && !"".equals(vo.getCustIndustry().trim())){
				vo.setCustIndustry(vo.getCustIndustry().trim());
			}
			if(null != vo.getCustLevel() && !"".equals(vo.getCustLevel().trim())){
				vo.setCustLevel(vo.getCustLevel().trim());
			}
			page.setTotal(customerDao.customerCountByQueryVo(vo));
			page.setRows(customerDao.selectCustomerByQueryVo(vo));
		}
		return page;
	}
	
	public Customer selectCustomerByCustId(Integer id){
		return customerDao.selectCustomerByCustId(id);
	}
	public void updateCustomerByCustId(Customer customer){
		customerDao.updateCustomerByCustId(customer);
	}
	public void deleteCustomerByCustId(Integer id){
		customerDao.deleteCustomerByCustId(id);
	}
}
