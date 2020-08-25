package kr.co.softsoldesk.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.co.softsoldesk.beans.JdbcBean;
import kr.co.softsoldesk.config.BeanConfigClass;
import kr.co.softsoldesk.mapper.MapperInterface;

public class MainClass {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfigClass.class);
		
		MapperInterface mapper = ctx.getBean("test_mapper", MapperInterface.class);
		
		JdbcBean bean1 = new JdbcBean();
		bean1.setCode("10");
		bean1.setTitle("파피용");
		bean1.setWriter("베르나르 베르베르");
		bean1.setPrice(13800);
		mapper.insert_data(bean1);
	
//		JdbcBean bean2 = new JdbcBean();
//		bean2.setCode("20");
//		bean2.setTitle("나무");
//		bean2.setWriter("베르나르 베르베르");
//		bean2.setPrice(12800);
//		mapper.insert_data(bean2);
		
		// update
//		JdbcBean bean4 = new JdbcBean();
//		bean4.setCode("10");
//		bean4.setTitle("개미");
//		mapper.update_data(bean4);
	
		// delete
		mapper.delete_data(10);
		
		
		List<JdbcBean> list1 = mapper.select_data();
		for(JdbcBean bean3:list1) {
			System.out.printf("code : %s\n",bean3.getCode());
			System.out.printf("title : %s\n",bean3.getTitle());
			System.out.printf("writer : %s\n",bean3.getWriter());
			System.out.printf("price : %d\n", bean3.getPrice());
			System.out.println("-----------------------------------");
		}
		
		ctx.close();
	}

}
