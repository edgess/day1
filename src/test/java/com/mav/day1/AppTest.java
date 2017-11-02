package com.mav.day1;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	view4();
    	view3();

    }
   

	public void view4() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		Order order = orderMapper.selectByPrimaryKey(1);
    	sqlSession.close();
    	System.out.println(order);;//打印结果：null，也就是没有查询出相应的记录
    }
    
    public void view3() {
    	SqlSession sqlSession = MyBatisUtil.getSqlSession();
    	//映射sql的标识字符串
    	String statement = "com.mav.day1.OrderMapper.selectByPrimaryKey";
    	//执行查询操作，将查询结果自动封装成Order对象返回
    	Order order = sqlSession.selectOne(statement,1);//查询orders表中id为1的记录
    	//使用SqlSession执行完SQL之后需要关闭SqlSession
    	sqlSession.close();
    	System.out.println(order);;//打印结果：null，也就是没有查询出相应的记录
    }
    public void view2() {
    	SqlSession sqlSession = MyBatisUtil.getSqlSession();
    	String statement = "com.mav.day1.userMapper.getUserCount";
    	Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("sexid", 0);
        map.put("usercount", -1);
		sqlSession.selectOne(statement,map);
    	sqlSession.close();
    	System.out.println(map.get("usercount"));
		
	}
    
    public void view1() {
    	SqlSession sqlSession = MyBatisUtil.getSqlSession();
    	String statement = "com.mav.day1.classMapper.getClass";//映射sql的标识字符串
    	//执行查询操作，将查询结果自动封装成Order对象返回
    	Classes classes = sqlSession.selectOne(statement,1);//查询orders表中id为1的记录
    	//使用SqlSession执行完SQL之后需要关闭SqlSession
    	sqlSession.close();
    	System.out.println(classes);//打印结果：null，也就是没有查询出相应的记录
	}
    
}
