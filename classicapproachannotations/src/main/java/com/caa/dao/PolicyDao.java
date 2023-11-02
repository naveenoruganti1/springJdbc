package com.caa.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.stereotype.Repository;

import com.caa.bo.PolicyBo;

@Repository
public class PolicyDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private final String GET_POLICIES="SELECT POLICY_NO,POLICY_HOLDER_NAME,POLICY_NAME,TENURE,PREMIUM_AMOUNT,INSURED_AMOUNT FROM policy";
	
	public List<PolicyBo> getAllPolicies(){
		return jdbcTemplate.execute(new GetPoliciesStatementCallBack());
	}
	
	public final class GetPoliciesStatementCallBack implements StatementCallback<List<PolicyBo>>{

		@Override
		public List<PolicyBo> doInStatement(Statement stmt) throws SQLException, DataAccessException {
			ResultSet rs = null;
			PolicyBo policyBo = null;
			List<PolicyBo> list = null;
			
			list = new ArrayList<PolicyBo>();
			rs = stmt.executeQuery(GET_POLICIES);
			while(rs.next()) {
				policyBo = new PolicyBo();
				policyBo.setPolicyNo(rs.getInt(1));
				policyBo.setPolicyHolder(rs.getString(2));
				policyBo.setPolicyName(rs.getString(3));
				policyBo.setTenure(rs.getString(4));
				policyBo.setPrimiumAmount(rs.getString(5));
				policyBo.setInsuredAmount(rs.getString(6));
				list.add(policyBo);
			}
			
			return list;
		}
	}
}
