package com.kh.springdb.model;

import jakarta.persistence.Entity;

import java.util.*;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;

/*
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator ="user_seq")
	@SequenceGenerator(name="user_seq", sequenceName = "user_seq", allocationSize=1);
	private int id;
	
	
	
	@Column(unique = true)
	private String username;
	
	private String password;
	private String name;
	private String email;
	private String address;
	private String phone;
	private String role; // 회원 / 관리자
	private  int coin;
	
	
	
	private List<Item> items = new ArrayList<>();
	
	//판매자가 판매한 내역 Sale을 만든 후 주석
	//@OntToMany(mappedBy = "seller")
	//private List<Sale> sellerSale;
	
	
	
	//판매자가 판매한 상품들 ""
	//@OneToMany(mappedBy = "seller")
	//private List<SaleItem> sellerSaleItem = new ArrayList<>();
	
	
	//구매자 결제 내역 
	
	
	
	
	//구매자가 주문 리스트
	
	
	
	
	
	
	//구매자가 사고싶은 내역의 장바구니
	//Cart 라는 장바구니를 이용해서 장바구니에 아이템을 담을 예정
	
	
	
	
	
}
*/