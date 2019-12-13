package org.dr.dao;

import java.util.List;

import org.dr.dto.PagingDTO;

public interface CrudDAO<V,K> {
	
	public V selectOne(K key);
	
	public boolean delete(K key);
	
	public List<V> getList(PagingDTO dto);

	boolean insert(V vo);
	boolean update(V vo);
	public int getCount();
	public boolean updateViewCnt(Long bno);
}
