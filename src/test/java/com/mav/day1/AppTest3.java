package com.mav.day1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import junit.framework.TestCase;

public class AppTest3 extends TestCase {
	public void testApp() {
		view0();
	}

	public void view1() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		ItMapper itMapper = sqlSession.getMapper(ItMapper.class);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map = itMapper.getItById(1);
		System.out.println(map);
		sqlSession.close();
	}

	public void view0() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		ItMapper itMapper = sqlSession.getMapper(ItMapper.class);
		List<Map<Object, Object>> map = new ArrayList<Map<Object, Object>>();
		map = itMapper.getAllItWithMap("A","N","N");
		for (Map<Object, Object> entityTemp : map) {
			System.out.println(entityTemp.toString());
		}
		sqlSession.close();
	}
}
