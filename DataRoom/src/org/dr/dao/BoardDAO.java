package org.dr.dao;

import java.util.List;

import org.dr.domain.BoardVO;
import org.dr.domain.SearchVO;

public interface BoardDAO extends CrudDAO<BoardVO, Long> {

	public int getCount();
	public boolean updateViewCnt(Long bno);
	public boolean deleteFile(String fn);
	public boolean update(BoardVO vo);
	public List<BoardVO> search(SearchVO vo);
	public int getSearchCount(SearchVO vo);
	
}
