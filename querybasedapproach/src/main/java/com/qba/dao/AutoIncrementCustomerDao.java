package com.qba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.qba.bo.CustomerBo;

@Repository
public class AutoIncrementCustomerDao {
	private final String SQL_INSERT_CUSTOMER="INSERT INTO customer (customer_nm,dob,gender) VALUES (?,?,?)";
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int saveCustomer(CustomerBo bo) {
		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new AIPreparedStatementCreator(bo),holder);
		
		return holder.getKey().intValue();
	}
	
	public final class AIPreparedStatementCreator implements PreparedStatementCreator{

		CustomerBo bo = null;
		
		public AIPreparedStatementCreator(CustomerBo bo) {
			this.bo = bo;
		}

		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			PreparedStatement preparedStatement = null;
			
			preparedStatement = con.prepareStatement(SQL_INSERT_CUSTOMER, new String[] {"customer_no"});
			preparedStatement.setString(1, bo.getCustomerName());
			preparedStatement.setString(2, bo.getDob());
			preparedStatement.setString(3, bo.getGender());
			
			return preparedStatement;
		}
	}
}
