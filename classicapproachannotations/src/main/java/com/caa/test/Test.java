package com.caa.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.caa.bo.PolicyBo;
import com.caa.config.JavaConfig;
import com.caa.dao.PolicyDao;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		PolicyDao policyDao = context.getBean("policyDao", PolicyDao.class);
		List<PolicyBo> policyBos = policyDao.getAllPolicies();
		policyBos.stream().forEach(System.out::println);
	}

}
