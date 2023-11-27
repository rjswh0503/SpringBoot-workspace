package com.kh.springdb.mapper;

import java.util.List;

import com.kh.springdb.model.Board;

public interface BoardMapper {
	List<Board> getAllBoards();
	
	
	
	//게시물 DB 저장 
	void insertBoard(Board board);
	
	
	//게시물 수정
	void UpdateBoard(Board board);
	
	
	
	
}
