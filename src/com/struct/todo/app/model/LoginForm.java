package com.struct.todo.app.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.struct.todo.app.config.DbConfig;
import com.struct.todo.app.dto.UserDto;
import com.struct.todo.app.exception.AppException;
import com.struct.todo.app.exception.ErrorCode;
import com.struct.todo.app.util.QueryConstant;

/**
 * @author arunkumar.angappan
 *
 */
public class LoginForm extends org.apache.struts.action.ActionForm {
    
	private static final long serialVersionUID = 5550053846233969863L;

	private long id;

	private String userName;

    private String password;

    
    public final long getId() {
		return id;
	}

	public final void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public UserDto checkLogin() {
    	
    	Connection connection = new DbConfig().getConnection();
    	UserDto user = new UserDto();
    	try {
			PreparedStatement statement = connection.prepareStatement(QueryConstant.LOGIN);
			statement.setString(1, this.getUserName());
			statement.setString(2, this.getPassword());
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				user.setId(result.getInt("id"));
				user.setUsername(result.getString("username"));
				user.setName(result.getString("name"));
				user.setEmail(result.getString("email"));
				user.setMobile(result.getString("mobile"));
				user.setDesignation(result.getString("designation"));				
			}
			connection.close();
			if (user.getId() == 0 )
				return null;
		} catch (SQLException e) {
			throw new AppException(ErrorCode.INTERNAL_ERROR, e);
		}
    	return user;
    }
}
