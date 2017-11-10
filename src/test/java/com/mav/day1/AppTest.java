package com.mav.day1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import junit.framework.TestCase;

public class AppTest extends TestCase {
	public void testApp() {
		// view9();
		// view8();
		view0();
		// view6();
		// view5();
		// view4();
		// view3();
		// view2();
		// view1();
	}

	public void view0() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<Map<Object, Object>>map = new ArrayList<Map<Object, Object>>();
		map = userMapper.getUserWithMap();
		System.out.println(map);
		sqlSession.close();
	}

	public void view9() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		System.out.println(userMapper.getUserById(userMapper.getUserIdMax()));
		sqlSession.close();
	}

	public void view8() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setName("edge");
		System.out.println(userMapper.getUserByEntity(user));
		sqlSession.close();
	}

	public void view7() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("age", 27);
		map.put("id", 1);
		System.out.println(userMapper.getUserByName(map));
		sqlSession.close();
	}

	public void view72() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		int age = 27;
		int id = 1;
		System.out.println(userMapper.getUserByName2(age, id));
		sqlSession.close();
	}

	public void view6() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("age", 27);
		List<User> users = userMapper.getUserByAge(map);
		for (User entityTemp : users) {
			System.out.println(entityTemp.toString());
		}
		sqlSession.close();
	}

	public void view5() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("sexid", 0);
		map.put("usercount", -1);
		userMapper.getUserCount(map);
		sqlSession.close();
		System.out.println(map.get("usercount"));
	}

	public void view4() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		Order order = orderMapper.selectByPrimaryKey(1);
		sqlSession.close();
		System.out.println(order);
	}

	public void view3() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		// 映射sql的标识字符串
		String statement = "com.mav.day1.OrderMapper.selectByPrimaryKey";
		// 执行查询操作，将查询结果自动封装成Order对象返回
		Order order = sqlSession.selectOne(statement, 1);// 查询orders表中id为1的记录
		// 使用SqlSession执行完SQL之后需要关闭SqlSession
		sqlSession.close();
		System.out.println(order);
		;// 打印结果：null，也就是没有查询出相应的记录
	}

	public void view2() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		String statement = "com.mav.day1.userMapper.getUserCount";
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("sexid", 0);
		map.put("usercount", -1);
		sqlSession.selectOne(statement, map);
		sqlSession.close();
		System.out.println(map.get("usercount"));

	}

	public void view1() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		String statement = "com.mav.day1.classMapper.getClass";// 映射sql的标识字符串
		// 执行查询操作，将查询结果自动封装成Order对象返回
		Classes classes = sqlSession.selectOne(statement, 1);// 查询orders表中id为1的记录
		// 使用SqlSession执行完SQL之后需要关闭SqlSession
		sqlSession.close();
		System.out.println(classes);// 打印结果：null，也就是没有查询出相应的记录
	}

}
