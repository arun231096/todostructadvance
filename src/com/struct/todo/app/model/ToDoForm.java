package com.struct.todo.app.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.struct.todo.app.config.DbConfig;
import com.struct.todo.app.exception.AppException;
import com.struct.todo.app.exception.ErrorCode;
import com.struct.todo.app.util.QueryConstant;

/**
 * @author arunkumar.angappan
 *
 */
public class ToDoForm extends ActionForm{

	private static final long serialVersionUID = -637363568861842138L;
	
	private int id;
	private String title;
	private String message;
	private int estimation;
	private Date startDate;
	private Date endDate;
	private String status;
	private int userId;

	public ToDoForm() {}
	public ToDoForm(int id, String title, String message, int estimation, Date startDate, Date endDate,
			String status, int userId) {
		super();
		this.id = id;
		this.title = title;
		this.message = message;
		this.estimation = estimation;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getEstimation() {
		return estimation;
	}
	public void setEstimation(int estimation) {
		this.estimation = estimation;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	

	@Override
	public String toString() {
		return "ToDoForm [id=" + id + ", title=" + title + ", message=" + message + ", estimation=" + estimation
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", status=" + status + ", userId=" + userId
				+ "]";
	}
	
	// DB Operations

	public boolean saveToDO() {
		Connection connection = new DbConfig().getConnection();
		this.validate();
		try {
			PreparedStatement statement = connection.prepareStatement(QueryConstant.INSERT_TODO, Statement.RETURN_GENERATED_KEYS);
			this.setStatement(statement);
			statement.executeUpdate();
			ResultSet result = statement.getGeneratedKeys();
			while(result.next()) {
				if (result.getInt(1) != 0) {
					this.setId(result.getInt(1));
					connection.close();
					return true;
				}
			}
		} catch (SQLException e) {
			throw new AppException(ErrorCode.INTERNAL_ERROR, e);
		}
		return false;
	}
	
	public boolean Update() {
		Connection connection = new DbConfig().getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(QueryConstant.UPDATE_TODO);
			statement = this.setStatement(statement);
			statement.setInt(8, this.getUserId());
			statement.setInt(9, this.getId());
			statement.execute();
			connection.close();
			return true;
		} catch (SQLException e) {
			throw new AppException(ErrorCode.INTERNAL_ERROR, e);
		}
	}
	
	public ToDoForm readToDO(int todoId) {
		Connection connection = new DbConfig().getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement(QueryConstant.READ_TODO);
			statement.setInt(1, todoId);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				ToDoForm form = this.formToDo(result);
				connection.close();
				return form;
			}
		} catch (SQLException e) {
			throw new AppException(ErrorCode.INTERNAL_ERROR, e);
		}
		return null;
	}

	public List<ToDoForm> getList(int userId) {
		Connection connection = new DbConfig().getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement(QueryConstant.READ_ALL_TODO_BY_USER);
			statement.setInt(1, userId);
			ResultSet result = statement.executeQuery();
			List<ToDoForm> todoList = new LinkedList<ToDoForm>();
			while(result.next()) {
				todoList.add(this.formToDo(result));
			}
			connection.close();
			return todoList;
		} catch (SQLException e) {
			throw new AppException(ErrorCode.INTERNAL_ERROR, e);
		}
	}
	
	public boolean delete(int todoId) {
		
			Connection connection = new DbConfig().getConnection();
			try {
				PreparedStatement statement = connection.prepareStatement(QueryConstant.DELETE_TODO);
				statement.setInt(1, todoId);
				statement.execute();
				connection.close();
				return true;
			} catch (SQLException e) {
				throw new AppException(ErrorCode.INTERNAL_ERROR, e);
			}
	}
	public PreparedStatement setStatement(PreparedStatement statement) throws SQLException {
		statement.setString(1, this.getTitle());
		statement.setString(2, this.getMessage());
		statement.setInt(3, this.getEstimation());
		statement.setDate(4, this.getStartDate());
		statement.setDate(5, this.getEndDate());
		statement.setString(6, this.getStatus());
		statement.setInt(7, this.getUserId());
		return statement;
	}
	
	public ToDoForm formToDo(ResultSet result) throws SQLException {
		ToDoForm form = new ToDoForm();
		form.setId(result.getInt("id"));
		form.setTitle(result.getString("title"));
		form.setMessage(result.getString("message"));
		form.setEstimation(result.getInt("estimation"));
		form.setStartDate(result.getDate("start_date"));
		form.setEndDate(result.getDate("end_date"));
		form.setStatus(result.getString("status"));
		form.setUserId(result.getInt("todo_user_id"));
		return form;
	}
	
	public void validate() {
		List<ErrorCode> errorList = new LinkedList<>();
		if(this.getTitle().isEmpty()) errorList.add(ErrorCode.TITLE_EMPTY);
		if(this.getMessage().isEmpty()) errorList.add(ErrorCode.MESSAGE_EMPTY);
		if(this.getEstimation() == 0) errorList.add(ErrorCode.ESTIMATION_EMPTY);
		if(this.getStartDate().compareTo(Date.valueOf(LocalDate.now())) < 0) errorList.add(ErrorCode.STARTDATE_ERROR);
		if(this.getEndDate().compareTo(Date.valueOf(LocalDate.now())) < 0 
				|| this.getEndDate().compareTo(this.getStartDate()) < 0) errorList.add(ErrorCode.ENDDATE_ERROR);
		if(this.getStatus().isEmpty()) errorList.add(ErrorCode.STATUS_EMPTY);
		if(this.getUserId() <= 0) errorList.add(ErrorCode.USERID_EMPTY);
		if(!errorList.isEmpty()) throw new AppException(errorList);
	}
}
