package com.remind.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.remind.board.dto.BoardType;
import com.remind.board.dto.MakeBoardDto;
import com.remind.board.dto.MessageDto;
import com.remind.board.dto.UserDto;

@Repository
public class AdminDaoImpl implements AdminDao{

	@Autowired
	private SqlSession sqlsession;
	
	// 관리자 페이지에서 게시물 타입(제목)등록
	@Override
	public void makeBoard(String type) throws Exception {
		sqlsession.insert("adminMapper.makeBoard", type);
	}

	// 해당 admin계정이 들고있는 게시물 제목 가져오기
	@Override
	public List<BoardType> getBoardTitleList() throws Exception {
		return sqlsession.selectList("adminMapper.getBoardTitleList");
	}

	// 게시판 지우기 
	@Override
	public int boardDelete(String type) throws Exception {
		return sqlsession.delete("adminMapper.deleteBoard", type);
	}

	// 게시판 이름 누르면 해당 게시판에 맞는 List 가져오기
	@Override
	public List<MakeBoardDto> getBoardListById(int id) throws Exception {
		return sqlsession.selectList("adminMapper.getBoardListById", id);
	}

	// 게시물 작성 
	@Override
	public void boardWrite(MakeBoardDto makeBoardDto) throws Exception {
		sqlsession.insert("adminMapper.boardWrite", makeBoardDto);
	}

	// 게시판 Id로 게시판 이름 찾기
	@Override
	public BoardType getBoardTitleById(int id) throws Exception {
		return sqlsession.selectOne("adminMapper.getBoardTitleById", id);
	}

	// 게시물 수 조회
	@Override
	public int boardCount(int id) throws Exception {
		return sqlsession.selectOne("adminMapper.boardCount", id);
	}

	// user 조회
	@Override
	public List<UserDto> selectUsers() throws Exception {
		return sqlsession.selectList("adminMapper.selectMembers");
	}

	// user 수
	@Override
	public int userCount() throws Exception {
		return sqlsession.selectOne("adminMapper.userCount");
	}

	// 멤버관리 (활성화/비활성화)Update
	@Override
	public int selectMemberUpdate(String id) throws Exception {
		return sqlsession.update("adminMapper.selectMemberUpdate", id);
	}

	// 멤버관리 비동기 검색
	@Override
	public List<UserDto> selectMemberSearch(Map<String, Object> map) throws Exception {
		return sqlsession.selectList("adminMapper.selectMemberSearch", map);
	}

	// 멤버관리에서 메시지 보내기 
	@Override
	public int MessageSend(MessageDto message) throws Exception {
		return sqlsession.insert("adminMapper.messageSend", message);
	}

	
}
