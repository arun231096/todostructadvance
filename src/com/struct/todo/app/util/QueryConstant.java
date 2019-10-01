package com.struct.todo.app.util;

public interface QueryConstant {

	// user Queries
	String INSERT_USER = new StringBuilder()
											.append("INSERT INTO todo_user (  ")
											.append(" username,               ")
											.append(" name,                   ")
											.append(" password,               ")
											.append(" designation,            ")
											.append(" email,                  ")
											.append(" mobile                  ")
											.append(") VALUES (?, ?, ?, ?, ?, ?)").toString();

	String UPDATE_USER = new StringBuilder()
											.append("UPDATE todo_user ")
											.append("SET              ")
											.append("username = ?,    ")
											.append("name = ?,        ")
											.append("password = ?,    ")
											.append("designation = ?, ")
											.append("email = ?,       ")
											.append("mobile = ?       ")
											.append("WHERE id = ?     ").toString();

	String DELETE_USER = new StringBuilder().append("DELETE FROM todo_user where id = ?").toString();

	String READ_USER = new StringBuilder()
										  .append("SELECT ")
										  .append("id,                           ")
										  .append("username,                     ")
										  .append("password,                     ")
										  .append("name,                         ")
										  .append("email,                        ")
										  .append("mobile,                       ")
										  .append("designation                   ")
										  .append("  FROM todo_user              ")
										  .append(" WHERE username = ?           ").toString();
	
	String READ_ALL_USER = new StringBuilder().append("").toString();
	
	// todo Queries
	String INSERT_TODO = new StringBuilder()
											.append("INSERT INTO todo_table (       ")
											.append(" title,                        ")
											.append(" message,                      ")
											.append("estimation,                    ")
											.append(" start_date,                   ")
											.append(" end_date,                     ")
											.append(" status,                       ")
											.append("todo_user_id                   ")
											.append(") VALUES (?, ?, ?, ?, ?, ?, ?) ").toString();

	String UPDATE_TODO = new StringBuilder()
											.append("UPDATE todo_table          ")
											.append("   SET                     ")
											.append("	   title = ?,           ")
											.append("       message = ?,        ")
											.append("	   estimation = ?,      ")
											.append("	   start_date = ?,      ")
											.append("	   end_date = ?,        ")
											.append("	   status= ?,           ")
											.append("	   todo_user_id = ?     ")
											.append("WHERE todo_user_id = ?     ")
											.append("AND id = ?                 ").toString();

	String DELETE_TODO = new StringBuilder()
											.append("DELETE FROM todo_table WHERE id = ?").toString();

	String READ_TODO = new StringBuilder()
										 .append("SELECT                 ")
										 .append("id,                    ")
										 .append("title,                 ")
										 .append("message,               ")
										 .append("estimation,            ")
										 .append("start_date,            ")
										 .append("end_date,              ")
										 .append("status,                ")
										 .append("todo_user_id           ")
										 .append("FROM todo_table        ")
										 .append("WHERE id = ?           ").toString();

	String READ_ALL_TODO_BY_USER = new StringBuilder()
													 .append("SELECT                 ")
													 .append("id,                    ")
													 .append("title,                 ")
													 .append("message,               ")
													 .append("estimation,            ")
													 .append("start_date,            ")
													 .append("end_date,              ")
													 .append("status,                ")
													 .append("todo_user_id           ")
													 .append("FROM todo_table        ")
													 .append("WHERE todo_user_id = ? ").toString();
	
	// Login query
	String LOGIN = new StringBuilder()
									  .append("SELECT ")
									  .append("id,                           ")
									  .append("username,                     ")
									  .append("name,                         ")
									  .append("email,                        ")
									  .append("mobile,                       ")
									  .append("designation                   ")
									  .append("  FROM todo_user              ")
									  .append(" WHERE username = ?           ")
									  .append("   AND password = ?           ").toString();
}
