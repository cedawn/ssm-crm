package com.gch.crm.service;

import com.gch.common.utils.Page;
import com.gch.crm.pojo.Customer;
import com.gch.crm.pojo.QueryVo;

public interface CustomerService {
	public Page<Customer> selectPageByQueryVo(QueryVo vo);
	public Customer selectCustomerByCustId(Integer id);
	public void updateCustomerByCustId(Customer customer);
	public void deleteCustomerByCustId(Integer id);
}
