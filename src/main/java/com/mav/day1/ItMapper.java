package com.mav.day1;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ItMapper {
	List<Map<Object, Object>> getAllItWithMap(@Param("class")String a, @Param("type")String b, @Param("belong")String c);

	Map<Object, Object> getItById(@Param("id") Integer id);
}
