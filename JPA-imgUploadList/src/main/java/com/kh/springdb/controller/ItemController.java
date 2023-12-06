package com.kh.springdb.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.kh.springdb.model.Item;
import com.kh.springdb.service.ItemService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ItemController {
	private final ItemService itemService;
	
	//메인페이지
	@GetMapping("/")
	public String mainPage(Model model) {
		List<Item> items = itemService.allItemView();
		model.addAttribute("items", items);
		return "index";
	}
	
	// 상품 전체 목록 페이지로 이동하기 위한 GetMapping
	@GetMapping("/item/list")
	public String itemList(Model model) {
		List<Item> items = itemService.allItemView();
		model.addAttribute("items", itemService.allItemView());
		return "itemList";
	}
	
	//상품 등록 페이지로 이동하기 위한 GetMapping
	@GetMapping("/item/new")
	public String itemSaveForm(Model model) {
		return "addItemForm";
	}
	
	// 클라언트가 등록한 상품 등록 내용을 DB에 업로드
	@PostMapping("/item/new")
	public String itemSave(Item item, MultipartFile imgFile) throws IllegalStateException, IOException {
		itemService.saveItem(item, imgFile);
		return "redirect:/";
	}
	
	// 아이템 상세보기 메서드
	@GetMapping("/item/view/{id}")
	public String itemDetailView(@PathVariable() int id, Model model) {
		model.addAttribute("item", itemService.getItemById(id));
		return "itemView";
	}
}	
