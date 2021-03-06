package com.remind.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.remind.board.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao {

	//@Autowired
	private SqlSession sqlsession;
	
	@Autowired
	public void setSqlsession(SqlSession sqlsseion) {
		this.sqlsession = sqlsseion;
	}
	
	 
	// 게시물 목록
	@Override
	public List<BoardDto> list() throws Exception {
		return sqlsession.selectList("boardMapper.list");
	}

	// 총 게시물 수
	@Override
	public int count() throws Exception {
		return sqlsession.selectOne("boardMapper.count");
	}
	
	// 게시물 총 개수 + 검색 적용
	@Override
	public int searchCount(String searchType, String keyword) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchType", searchType);
		map.put("keyword", keyword);
		return sqlsession.selectOne("boardMapper.searchCount", map);
	}


	// 게시물 목록 + 페이징
	@Override
	public List<BoardDto> listPage(Map<String, Integer> map) throws Exception {
		return sqlsession.selectList("boardMapper.listPage", map);
	}

	
	// 게시물 목록 + 페이징 + 검색
	@Override
	public List<BoardDto> listPageSearch(Map<String, Object> map) throws Exception {
		return sqlsession.selectList("boardMapper.listPageSearch", map);
	}


	// 게시물 조회
	@Override
	public BoardDto boardDetail(int bno) throws Exception {
		return sqlsession.selectOne("boardMapper.boardDetail", bno);
		
	}

	// 게시물 생성
	@Override
	public int boardWrite(BoardDto boardDto) throws Exception {
		return sqlsession.insert("boardMapper.boardWrite", boardDto);
	}

	// 게시물 수정
	@Override
	public int boardUpdate(BoardDto boardDto) throws Exception {
		return sqlsession.update("boardMapper.boardUpdate", boardDto);
	}

	// 게시물 삭제
	@Override
	public int boardDelete(int bno) throws Exception {
		return sqlsession.delete("boardMapper.boardDelete", bno);
	}

	// 첨부파일 업로드
	@Override
	public int insertFile(Map<String, Object> map) throws Exception {
		return sqlsession.insert("boardMapper.insertFile", map);
	}

	// 첨부파일 조회
	@Override
	public List<Map<String, Object>> selectFileList(int bno) throws Exception {
		return sqlsession.selectList("boardMapper.selectFileList", bno);
	}

	// 첨부파일 다운
	@Override
	public Map<String, Object> selectFileInfo(int file_no) throws Exception {
		return sqlsession.selectOne("boardMapper.selectFileInfo", file_no);
	}

	// 첨부파일 수정
	@Override
	public void updateFile(Map<String, Object> map) throws Exception {
		sqlsession.update("boardMapper.updateFile", map);
	}

	// 첨부파일 제한
	@Override
	public int fileCount(int bno) throws Exception {
		return sqlsession.selectOne("boardMapper.fileCount", bno);
	}
	
	
	
	
	

}
