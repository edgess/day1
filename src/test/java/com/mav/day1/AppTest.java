package com.mav.day1;

import org.apache.ibatis.session.SqlSession;

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
    	System.out.println("123");
    	
    	SqlSession sqlSession = MyBatisUtil.getSqlSession();

        String statement = "com.mav.day1.classMapper.getClass";//映射sql的标识字符串
        //执行查询操作，将查询结果自动封装成Order对象返回
        Classes classes = sqlSession.selectOne(statement,1);//查询orders表中id为1的记录
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(classes);//打印结果：null，也就是没有查询出相应的记录

    }
}
