package com.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.dao.BoardReplyDAO;
import com.board.dto.BoardReplyVO;

@Service
public class BoardReplyServiceImpl implements BoardReplyService {

	@Autowired
	private BoardReplyDAO dao;
	
	// 해당 글에 대한 댓글 얻어오기
	@Override
	public List<BoardReplyVO> getListReply(int bno) throws Exception {
		return dao.getReplyList(bno);
	}
	
	
	// 댓글 페이징
	@Override
	public List<BoardReplyVO> boardReplyPage(int displayPost, int postNum, int bno) throws Exception {
		return dao.boardReplyPage(displayPost, postNum, bno);
	}

	// 댓글 쓰기
	@Override
	public void writeReply(BoardReplyVO replyVO) throws Exception {
		dao.writeReply(replyVO);
	}

	
	// 선택한 댓글 하나 가져오기
	@Override
	public BoardReplyVO getReplyOne(int rno) throws Exception {
		return dao.getReplyOne(rno);
	}

	// 댓글 수정
	@Override
	public void updateReply(BoardReplyVO replyVO) throws Exception {
		dao.updateReply(replyVO);
	}

	// 댓글 삭제
	@Override
	public void deleteReply(int rno) throws Exception {
		dao.deleteReply(rno);
	}

	// 댓글 개수
	@Override
	public int getBoardReplyCount(int bno) throws Exception {
		return dao.getBoardReplyCount(bno);
	}

	

}
