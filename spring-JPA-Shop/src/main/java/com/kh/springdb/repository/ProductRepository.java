package com.kh.springdb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kh.springdb.vo.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
		
	
	
	
	
	
	/*
	public void CreateProductList() {
		Product product = new Product();
		product.setProduct_name("테스터 제품");
		product.setPrice(1000);
		product.setCategory("가전");
	}
	*/

}

/*
 Repository 
 
  Spring Data JPA 에서 제공하는 인터페이스
  데이터베이스에서 User 엔티티에 접근하는데 사용
  기본적인 CRUD작업을 수행할 수 있는 매서드를 제공
  
  	예를들어 
  		조회 : 전체조회(findAll)  아이디 하나만 조회(findByid)
  		저장 : save
  		삭제 : deleteById
  
  
  
 * */
