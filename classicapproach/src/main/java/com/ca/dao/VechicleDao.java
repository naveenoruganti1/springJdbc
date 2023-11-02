package com.ca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.ca.bo.VechicleBo;

public class VechicleDao {
	private final String SQL_GET_VECHICLES_BY_MODEL_NM = "SELECT vehicle_no,model_name,manufacturer,registration_no,color,fuel_type,lease_amount FROM vehicles where model_name like ?";
	private JdbcTemplate jdbcTemplate;

	public VechicleDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<VechicleBo> getVechiclesByModelNM(String modelName) {
		return jdbcTemplate.execute(new GetVechiclesByModelNamePreparedStatementCreator(modelName),
				new GetVechiclesByModelNamePreparedStatementCallBack());
	}

	public final class GetVechiclesByModelNamePreparedStatementCreator implements PreparedStatementCreator {
		private String modelName = null;

		public GetVechiclesByModelNamePreparedStatementCreator(String modelName) {
			this.modelName = modelName;
		}

		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			PreparedStatement pstmt = null;

			pstmt = con.prepareStatement(SQL_GET_VECHICLES_BY_MODEL_NM);
			pstmt.setString(1, "%"+modelName+"%");
			return pstmt;
		}
	}

	public final class GetVechiclesByModelNamePreparedStatementCallBack
			implements PreparedStatementCallback<List<VechicleBo>> {
		@Override
		public List<VechicleBo> doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
			ResultSet rs = null;
			VechicleBo vechicleBo = null;
			List<VechicleBo> vechicleBos = null;

			vechicleBos = new ArrayList<VechicleBo>();
			rs = ps.executeQuery();
			while (rs.next()) {
				vechicleBo = new VechicleBo();
				vechicleBo.setVechicleNo(rs.getInt(1));
				vechicleBo.setModelName(rs.getString(2));
				vechicleBo.setManufacturer(rs.getString(3));
				vechicleBo.setRegistrationNo(rs.getString(4));
				vechicleBo.setColor(rs.getString(5));
				vechicleBo.setFuelType(rs.getString(6));
				vechicleBo.setAmount(rs.getFloat(7));
				vechicleBos.add(vechicleBo);
			}

			return vechicleBos;
		}
	}
}
