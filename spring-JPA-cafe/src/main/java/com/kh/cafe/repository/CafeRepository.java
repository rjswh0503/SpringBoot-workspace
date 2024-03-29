package com.kh.cafe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.kh.cafe.vo.Cafe;

import jakarta.persistence.Column;

public interface CafeRepository extends JpaRepository<Cafe, Long> {
	//특정 문자열을 포함한 엔티티를 검색하는데 사용하는 메서드
	List<Cafe>findByNameContaining(String keyword);
	 //@Query("SELECT b FROM Cafe b WHERE b.name LIKE %:keyword%")
	 //1. 만약에 보여줄 것이 많다. => list로 담아서 한 번에 보여주기
	    //List<Cafe> findCafe(@Param("keyword") String keyword);
	 
	 //2. 보여줄 것이 하나 => cafe 객체 하나만 호출할 것 
	 

	
	
}




/*
 Query creation : spring data jpa에서 제공하는 기능
 메서드에 규칙이 존재하고 규칙에 따라서 메서드를 생성해주는 기능 
 메서드 이름으로 데이터베이스 쿼리를 생성할 수 있음 
 
 
  List<Cafe>findByNameContaining(String keyword);
  
  JPA 규칙을 지정해서 이 규칙만 지켜주면 내가 알아서 쿼리를 만들어줄게 
  
  
  
  
  findBy+내가 찾고싶은 변수명
  예를들어 Cafe라는 Class에 작성해놓은 
  private Long cafe_id;
	private String name;
	private String location;
	private String opening_hours; 에서
	
	지역을 검색하고 싶다면 
	findByLocation(String location)
	=> SELECT * FROM Cafe where location = ?
	
	
	findByNameContaining(String keyword);
	Containing => 해당하는 변수명이 특정 변수에 대한 검색을 Like로 진행할 수 있게 도와줌 
	
	
	
	운영시간을 검색하고 싶다면
	findByopening_hours(String opening_hours)
	=> SELECT * FROM Cafe where opening_hours = ?
  
  
  총 갯수를 계산해주는 메서드를 만들고 싶다면
  countBy 클래스에 적어준 변수명
  	countByLocation(String Location)
  	=> SELECT COUNT(*) FORM Cafe where location = ?
  	
  	
  	
  	존재여부를 확인해주는 메서드를 만들고 싶다면 
  	existsBy 클래스에 적어준 변수명
  	existsByLocation(String Location)
  	=> SELECT CASE WHEN COUNT(*) > 0 THEN true
  										ELSE false
  				END FROM Cafe where location = ?
  				
  		
  	만약에 삭제하고 싶다면 
  	deleteBy 클래스에 적어준 변수명
  	deleteByLocation(Strong Location)
  	DELETE FROM Cafe WHERE location = ?			
  		
  
  
  
  
  */
