package org.dr.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public enum MyBatisLoader {

	INSTANCE;
	SqlSessionFactory factory;
	
	public SqlSessionFactory getConnection() {
		return this.factory;
	}
	MyBatisLoader(){
		String resource = "mybatis-comfig.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
