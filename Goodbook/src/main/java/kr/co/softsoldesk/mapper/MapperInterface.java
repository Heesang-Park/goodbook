package kr.co.softsoldesk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.softsoldesk.beans.JdbcBean;

public interface MapperInterface {
	// 오라클의 컬럼과 jdbcBean의 컬럼명을 일치시킬시 생략 가능
//		@Results({
//			@Result(column = "int_data", property = "int_data"), 
//			@Result(column = "str_data", property = "str_data")
//		})
	
	@Select("select code, title, writer, price from goodbook ")
	List<JdbcBean> select_data(); // JdbcBean에 setting 됨
	
	@Insert("insert into goodbook (code, title, writer, price) values(#{code}, #{title}, #{writer}, #{price})")
	void insert_data(JdbcBean bean); // JdbcBean bean  객체를 참고하여 자동 매핑
	
	@Update("update goodbook set title = #{title} where code = #{code}")
	void update_data(JdbcBean bean);
	
	@Delete("delete from goodbook where code = #{code}")
	void delete_data(int code);
	
	
}
