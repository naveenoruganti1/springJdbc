package com.ca.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ca.bo.VechicleBo;
import com.ca.dao.VechicleDao;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(""
				+ "com/ca/commons/application-context.xml");
		VechicleDao dao = context.getBean("vechicleDao", VechicleDao.class);
		List<VechicleBo> bos = dao.getVechiclesByModelNM("FKP 37");
		bos.stream().forEach(System.out::println);
	}
}
