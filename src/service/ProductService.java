package service;

import com.jsp.dao.ProductDao;
import com.jsp.dto.Product;


public class ProductService {
	ProductDao productDao = new ProductDao();
	public Product saveProduct(Product product) {
		return productDao.saveProduct(product);
	}
	
	public boolean deleteCustomerById(int ID) {
		return productDao.deleteProductById(ID);
	}
	
	public int updateProductById(Product product) {
		return productDao.updateProductById(product);
	}
	
	public void getProductALL() {
		productDao.getProductALL();
	}
	
	public Product getProductById(int id) {
		return productDao.getProductById(id);
	}
}
