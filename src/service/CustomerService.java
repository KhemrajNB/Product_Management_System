package service;

import com.jsp.dao.CustomerDao;
import com.jsp.dto.Customer;

public class CustomerService {
	CustomerDao customerDao = new CustomerDao();
	public Customer saveCustomer(Customer customer) {
		return customerDao.saveCustomer(customer);
	}
	
	public boolean deleteCustomerById(int ID) {
		return customerDao.deleteCustomerById(ID);
	}
	
	public int updateCustomerById(Customer customer) {
		return customerDao.updateCustomerById(customer);
	}
	
	public void getCustomerALL() {
		customerDao.getCustomerALL();
	}
	
	public Customer getCustomerById(int id) {
		return customerDao.getCustomerById(id);
	}
}
