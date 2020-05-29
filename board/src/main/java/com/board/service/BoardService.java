package com.board.service;

import java.util.List;

import com.board.dto.BoardVO;

public interface BoardService {

	// 게시물 목록
	public List<BoardVO> list() throws Exception;

	// 게시물 쓰기
	public void write(BoardVO vo) throws Exception;

	// 게시물 조회
	public BoardVO listOne(int bno) throws Exception;

	// 게시물 수정
	public void BoardUpdate(BoardVO vo) throws Exception;
	
	// 게시물 삭제
	public void BoardDelete(int bno) throws Exception;
}