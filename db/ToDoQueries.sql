use AML_Training;
INSERT INTO todo_user (username, name, password, designation,email, mobile)
VALUES ('arusdsdn', 'Arunkfdfumar', 'arundsd123', 'Developer', 'arunkumar.angappasdsdsn@objectfrontier.com', '80128939454541');

INSERT INTO todo_table (title, message, estimation, start_date, end_date, status, todo_user_id)
VALUES ('Struct', 'complete on monday', 2, '2019-09-23', '2019-09-24', 'completed', 18);

SELECT todo_user.id, todo_user.username, todo_user.name, todo_user.email, todo_user.mobile, todo_user.designation 
  FROM todo_user 
 WHERE todo_user.username = 'arun' 
   AND todo_user.password = 'arun123';

UPDATE todo_table         
   SET                    
	   title = '',          
       message = '',       
	   estimation = 2,     
	   start_date = '',     
	   end_date = '',       
	   status= '',          
	   todo_user_id = 1    
WHERE todo_user_id = 1    
AND id = 5                ;

ALTER TABLE todo_user ADD CONSTRAINT uniquekey UNIQUE(username);
ALTER TABLE todo_user ADD CONSTRAINT uniquekey UNIQUE(email);
ALTER TABLE todo_user ADD CONSTRAINT uniquekey UNIQUE(mobile);
ALTER TABLE todo_user ADD CONSTRAINT uniquekey UNIQUE(password);

ALTER TABLE todo_table ALTER COLUMN start_date DATE;
ALTER TABLE todo_table ALTER COLUMN end_date DATE;

SELECT *
FROM INFORMATION_SCHEMA.COLUMNS
WHERE table_name = 'todo_table';

DELETE FROM todo_user where id = 20;
   SELECT id, title, message, estimation, start_date, end_date, status, todo_user_id FROM todo_table WHERE todo_user_id = 2;
   SELECT *FROM todo_user
   SELECT id, title, message, estimation, start_date, end_date, status, todo_user_id FROM todo_table WHERE id = 2;

   select * from todo_user;
   select * from todo_table;

ALTER TABLE todo_table
   ADD CONSTRAINT FK_TodoTable_ToDoUser_Cascade
   FOREIGN KEY (todo_user_id) REFERENCES todo_user(id) ON DELETE CASCADE

CREATE PROCEDURE selectAlltodo(@id AS int)
AS
BEGIN
SELECT * FROM todo_table
WHERE id= @id
END;

EXEC selectAlltodo 15;

DROP PROCEDURE selectAlltodo;