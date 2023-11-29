package com.kh.board.vo;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

@Table(name = "Boards")
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="board_id_sequence")
	@SequenceGenerator(name="board_id_sequence", sequenceName="board_id_sequence",allocationSize=1)
	@Column(name = "board_id")
	private Long board_id;
	
	private String title;
	private String content;
	private String author;
	
	
	


}
