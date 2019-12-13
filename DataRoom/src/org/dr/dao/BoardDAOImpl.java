package org.dr.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.dr.domain.BoardVO;
import org.dr.domain.SearchVO;
import org.dr.dto.PagingDTO;
import org.dr.util.MyBatisLoader;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

@Log4j
public class BoardDAOImpl implements BoardDAO{
	private SqlSessionFactory factory = MyBatisLoader.INSTANCE.getConnection(); 
			
	@Override
	public boolean insert(BoardVO vo) {
		boolean result = false;
		try (SqlSession session = factory.openSession()) {
			  int res = session.insert("org.dr.dao.BoardMapper.insert", vo);
			  
			  List<String> fnames = vo.getFnames();
			  
			  System.out.println("--------------------------------" + fnames);
			  
			  if(fnames.size() > 0) {
				  				  
				  for (int i = 0; i < fnames.size(); i++) {
					  
					  System.out.println("1111111111111111-------------------:" + fnames.get(i)+":");
					  
					  int red = session.insert("org.dr.dao.BoardMapper.fileInsert",fnames.get(i));
				  }
			  }
			  result=res==1?true:false;
			  session.commit();
			  System.out.println(result);
			  
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public boolean update(BoardVO vo) {
		boolean result = false;
		try (SqlSession session = factory.openSession()) {

			int res = session.update("org.dr.dao.BoardMapper.update",vo);
			  List<String> fnames = vo.getFnames();
			  
			  System.out.println("--------------------------------" + fnames);
			  
			  if(fnames.size() > 0) {
				  				  
				  for (int i = 0; i < fnames.size(); i++) {
					  
					  System.out.println("1111111111111111-------------------:" + fnames.get(i)+":");
					  vo.setFname(fnames.get(i));
					  int red = session.insert("org.dr.dao.BoardMapper.fileInsert2",vo);
				  }
			  }
			
			result = res==1?true:false;
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public List<BoardVO> getList(PagingDTO dto) {
		List<BoardVO> result = null;

		try (SqlSession session = factory.openSession()) {

			result = session.selectList("org.dr.dao.BoardMapper.selectList", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int getCount() {
		int result = 0;

		try (SqlSession session = factory.openSession()) {

			result = session.selectOne("org.dr.dao.BoardMapper.getCount");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	public static void main(String[] args) {
		BoardDAO dao = new BoardDAOImpl();
		BoardVO vo = new BoardVO();
		vo.setTitle("寃뚯떆�뙋 �뼱�젮��");
		vo.setContent("�꽭�긽�뿉 �돩�슫寃� �뾾�떎");
		vo.setWriter("�늿臾�");
		dao.insert(vo);
		System.out.println(vo);
	}

	@Override
	public boolean updateViewCnt(Long bno) {
		int result = 0;

		try (SqlSession session = factory.openSession()) {
			result = session.update("org.dr.dao.BoardMapper.updateView", bno);
			log.info("result: "+result);
			session.commit();
			System.out.println(result);
			  
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result == 1;
	}

	@Override
	public BoardVO selectOne(Long key) {
		BoardVO result = null;
		try (SqlSession session = factory.openSession()) {

			result = session.selectOne("org.dr.dao.BoardMapper.selectOne", key);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public boolean delete(Long key) {
		boolean result = false;
		try {
			SqlSession session = factory.openSession();
			int del = session.delete("org.dr.dao.BoardMapper.delete",key);
			 session.commit();
			 result=del==1?true:false;
			 System.out.println(result);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean deleteFile(String fn) {
		boolean result = false;
		try (SqlSession session = factory.openSession()) {

			int results = session.delete("org.dr.dao.BoardMapper.deleteFile", fn);
			session.commit();
			result = results ==1?true:false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<BoardVO> search(SearchVO vo) {
		List<BoardVO> result = null;
		try (SqlSession session = factory.openSession()) {

			result = session.selectList("org.dr.dao.BoardMapper.search", vo);
			
			log.info("vo...." + vo);
			
			log.info("result.... " + result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int getSearchCount(SearchVO vo) {
		int result = 0;

		try (SqlSession session = factory.openSession()) {

			result = session.selectOne("org.dr.dao.BoardMapper.getSearchCount", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}
