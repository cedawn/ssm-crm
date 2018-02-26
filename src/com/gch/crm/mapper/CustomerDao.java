package com.gch.crm.mapper;

import java.util.List;

import com.gch.crm.pojo.Customer;
import com.gch.crm.pojo.QueryVo;

public interface CustomerDao {
	public Integer customerCountByQueryVo(QueryVo vo);
	public List<Customer> selectCustomerByQueryVo(QueryVo vo);
	public Customer selectCustomerByCustId(Integer id);
	public void updateCustomerByCustId(Customer customer);
	public void deleteCustomerByCustId(Integer id);
}
