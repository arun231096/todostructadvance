package com.struct.todo.app.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.struts.action.ActionForm;

import com.struct.todo.app.config.DbConfig;
import com.struct.todo.app.exception.AppException;
import com.struct.todo.app.exception.ErrorCode;
import com.struct.todo.app.util.QueryConstant;

/**
 * @author arunkumar.angappan
 *
 */
public class UserDetailsForm extends ActionForm{

	private static final long serialVersionUID = -7914999478683535625L;
	private int id;
	private String name;
	private String username;
	private String password;
	private String designation;
	private String email;
	private String mobile;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public boolean save() throws SQLException {
		
		Connection connection = new DbConfig().getConnection();
		PreparedStatement statement = connection.prepareStatement(QueryConstant.INSERT_USER, Statement.RETURN_GENERATED_KEYS);
		this.setStatement(statement);
		statement.executeUpdate();
		ResultSet result = statement.getGeneratedKeys();
		while (result.next()) {
			if(result.getInt(1) != 0) {
				connection.close();
				return true;
			}
		}
		return false;
	}
	
	public boolean update() {
		Connection connection = new DbConfig().getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(QueryConstant.UPDATE_USER);
			statement = this.setStatement(statement);
			statement.setInt(7, this.getId());
			statement.execute();
			return true;
		} catch (SQLException e) {
			throw new AppException(ErrorCode.INTERNAL_ERROR, e);
		}
	}
	public UserDetailsForm read(String username) {
		Connection connection = new DbConfig().getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(QueryConstant.READ_USER);
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				UserDetailsForm userdetail = new UserDetailsForm();
				userdetail.setId(result.getInt("id"));
				userdetail.setName(result.getString("name"));
				userdetail.setUsername(result.getString("username"));
				userdetail.setDesignation(result.getString("designation"));
				userdetail.setPassword(result.getString("password"));
				userdetail.setEmail(result.getString("email"));
				userdetail.setMobile(result.getString("mobile"));
				return userdetail;
			}
		} catch (SQLException e) {
			throw new AppException(ErrorCode.INTERNAL_ERROR, e);
		}
			
		return null;
	}

	public boolean delete(int id) {
		Connection connection = new DbConfig().getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(QueryConstant.DELETE_USER);
			statement.setInt(1, id);
			statement.execute();
			return true;
		} catch (SQLException e) {
			throw new AppException(ErrorCode.INTERNAL_ERROR, e);
		}
	}
	
	public PreparedStatement setStatement(PreparedStatement statement) throws SQLException {
		statement.setString(1, this.getUsername());
		statement.setString(2, this.getName());
		statement.setString(3, this.getPassword());
		statement.setString(4, this.getDesignation());
		statement.setString(5, this.getEmail());
		statement.setString(6, this.getMobile());
		return statement;
	}
	@Override
	public String toString() {
		return "UserDetailsForm [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", designation=" + designation + ", email=" + email + ", mobile=" + mobile + "]";
	}
	
}
