package org.dr.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class BoardVO {
	private Long bno;
	private String title,content,writer;
	private Date regdate,updatedate;
	private int viewcnt;
	private int filecnt;
	private List<String> fnames;
	private String fname;
	private String hashtag;
	public BoardVO() {
		fnames = new ArrayList<>();
	}
	
	public void addFileName(String fname) {
		fnames.add(fname);
	}
	
}
