package com.mav.day1;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {

	Map<String, Integer> getUserCount(Map<String, Integer> map);

	int getUserCount2();

	int getUserIdMax();

	User getUserById(Integer id);

	List<User> getUserByAge(Map<String, Integer> map);

	List<User> getUserByName(Map<String, Integer> map);

	List<User> getUserByName2(@Param("age") Integer age, @Param("id") Integer id);

	List<User> getUserByEntity(User user);
	
	List<Map<Object, Object>>    getUserWithMap();

}