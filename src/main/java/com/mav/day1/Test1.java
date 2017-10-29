package com.mav.day1;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test1 {
	public static void main(String[] args) throws Exception {
		//getone();
		//getall();
		//add();
		//dele();
		//edit();
		
	}
	public static void edit() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		String statement = "com.mav.day1.userMapper.updateUser";
		User user = new User();
		user.setId(4);
        user.setName("qiqi");
        user.setAge(15);
        int retResult = sqlSession.update(statement, user);
        sqlSession.close();
        System.out.println(retResult);
	}
	
	public static void add() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		String statement = "com.mav.day1.userMapper.addUser";
		User user = new User();
        user.setName("qiqi");
        user.setAge(10);
        //执行插入操作
        int retResult = sqlSession.insert(statement,user);
        //手动提交事务
        //sqlSession.commit();
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(retResult);
	}
	
	public static void dele() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		String statement = "com.mav.day1.userMapper.deleteUser";
		int retResult =sqlSession.delete(statement,3);
		sqlSession.close();
		System.out.println(retResult);
		
	}
	
	public static void getall() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getAllUsers是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "com.mav.day1.userMapper.getAllUsers";//映射sql的标识字符串
        //执行查询操作，将查询结果自动封装成List<User>返回
        List<User> lstUsers = sqlSession.selectList(statement);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(lstUsers);
    }		

	
	public static void getone() {
        //mybatis的配置文件
        String resource = "conf.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = Test1.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource); 
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        //映射sql的标识字符串
        String statement = "com.mav.day1.userMapper.getUser";
        //执行查询返回一个唯一user对象的sql
        User user = session.selectOne(statement, 2);
        System.out.println(user);
	}
}

