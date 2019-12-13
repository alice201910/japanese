package org.dr.domain;

import org.dr.dto.PagingDTO;

import lombok.Data;

@Data
public class SearchVO {
	private String type;
	private String keyword;
	private PagingDTO paging;
	private int page;
	private int amount;
	
	/*
	 * public SearchVO(){ this.page = paging.getPage(); this.amount =
	 * paging.getAmount(); }
	 */


}
