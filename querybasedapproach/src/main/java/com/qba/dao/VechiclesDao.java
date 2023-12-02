package com.qba.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.qba.bo.VechiclesBo;

@Repository
public class VechiclesDao {
	private final String GET_NOOF_VECHICLES="select count(1) from vehicles";
	private final String GET_MODEL_NM_BY_VECHICLE_NO="select model_name from vehicles where vehicle_no=?";
	private final String SQL_GET_VEHICLES_BY_VEHICLE_NO = "SELECT vehicle_no,model_name,manufacturer,registration_no,color,fuel_type,lease_amount FROM vehicles where vehicle_no=?";
	private final String SQL_GET_VEHICLES_BY_MODEL_NM = "SELECT vehicle_no,model_name,manufacturer,registration_no,color,fuel_type,lease_amount FROM vehicles where model_name like ?";
	private final String SQL_GET_PARTIAL_VEHICLES_BY_MODEL_NM = "SELECT vehicle_no,model_name,manufacturer FROM vehicles where model_name like ?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int getNoofVechicles() {
		return jdbcTemplate.queryForObject(GET_NOOF_VECHICLES, Integer.class);
	}
	
	public String getModelName(int vehicleNo) {
		return jdbcTemplate.queryForObject(GET_MODEL_NM_BY_VECHICLE_NO, String.class, vehicleNo);
	}
	
	public VechiclesBo getVehiclesByVehicleNo(int vehicleNo) {
		return jdbcTemplate.queryForObject(SQL_GET_VEHICLES_BY_VEHICLE_NO, new VehicleRowMapper(), vehicleNo);
	}
	
	public List<VechiclesBo> getVehiclesByModelName(String modelName){
		return jdbcTemplate.query(SQL_GET_VEHICLES_BY_MODEL_NM, new VehicleRowMapper(), "%"+modelName+"%");
	}
	
	public List<Map<String, Object>> getVehicles(String modelName){
		return jdbcTemplate.queryForList(SQL_GET_PARTIAL_VEHICLES_BY_MODEL_NM, "%"+modelName+"%");
	}
	private final class VehicleRowMapper implements RowMapper<VechiclesBo>{

		@Override
		public VechiclesBo mapRow(ResultSet rs, int rowNum) throws SQLException {
			VechiclesBo bo = new VechiclesBo();
			bo.setVechicleNo(rs.getInt(1));
			bo.setModelName(rs.getString(2));
			bo.setManufacturer(rs.getString(3));
			bo.setRegistrationNo(rs.getString(4));
			bo.setColor(rs.getString(5));
			bo.setFuelType(rs.getString(6));
			bo.setAmount(rs.getFloat(7));
			return bo;
		}
	}
}
