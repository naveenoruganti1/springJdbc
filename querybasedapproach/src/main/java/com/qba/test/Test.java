package com.qba.test;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.qba.bo.CustomerBo;
import com.qba.bo.VechiclesBo;
import com.qba.config.JavaConfig;
import com.qba.dao.AutoIncrementCustomerDao;
import com.qba.dao.VechiclesDao;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
//		VechiclesDao vechiclesDao = context.getBean("vechiclesDao", VechiclesDao.class);
//		int count = vechiclesDao.getNoofVechicles();
//		String model = vechiclesDao.getModelName(2);
//		VechiclesBo vechiclesBo = vechiclesDao.getVehiclesByVehicleNo(1);
//		List<VechiclesBo> list = vechiclesDao.getVehiclesByModelName("FKP 37");
//		List<Map<String,Object>> maps = vechiclesDao.getVehicles("FKP 37");
//		System.out.println("No of Vehicles: "+count);
//		System.out.println("Model Name: "+model);
//		System.out.println(vechiclesBo);
//		list.stream().forEach(System.out::println);
//		System.out.println(maps);
		AutoIncrementCustomerDao dao = context.getBean("autoIncrementCustomerDao", AutoIncrementCustomerDao.class);
		CustomerBo bo = new CustomerBo();
		bo.setCustomerName("michael");
		bo.setDob("01/08/1997");
		bo.setGender("Male");
		int pk = dao.saveCustomer(bo);
		System.out.println(pk);
	}

}
