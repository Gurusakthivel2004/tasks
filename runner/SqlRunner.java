package runner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import exception.CustomException;
import pojo.Employee;
import pojo.EmployeeRelation;
import tasks.SqlTask;

public class SqlRunner {

    Logger logger = Logger.getLogger(FileRunner.class.getName());	
    SqlTask sqltask = new SqlTask();
    
	public static void main(String[] args) {	
		SqlRunner sqlRunner = new SqlRunner();
		sqlRunner.run(sqlRunner);
	}
	
	public void run(SqlRunner sqlRunner) {
		sqlRunner.logger.info("Enter the question number: ");
	    try(Scanner reader = new Scanner(System.in);
	    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/incubationDB","root","root");  
	    	) {
	    	int questionNo = reader.nextInt();
		    reader.nextLine();
		    Statement statement=con.createStatement();
	    	switch(questionNo) {
		    
				case 1:
					sqlRunner.handleCreateTable(statement);
					break;
					
				case 2:
					sqlRunner.handleAddData(statement, reader);
					break;
					
				case 3:
					sqlRunner.handleGetData(statement, reader);
					break;
					
				case 4:
					sqlRunner.handleUpdateEmployee(statement, reader);
					break;
					
				case 5:
					sqlRunner.handleNrecords(statement, reader);
					break;
					
				case 6:
					sqlRunner.handleNCustomRecords(statement, reader);
					break;
					
				case 7:
					sqlRunner.handleDelete(statement, reader);
					break;
					
				case 9:
					sqlRunner.handleCreateTableRelation(statement);
					break;
					
				case 10:
					sqlRunner.handleAddDataRelations(statement, reader);
					break;
					
				case 11:
					sqlRunner.handleGetEmployeeRelations(statement, reader);
					break;
					
				case 12:
					sqlRunner.handleGetNEmployeeRelations(statement, reader);
					break;
					
	    	}	
		} catch (Exception exception) {
			sqlRunner.logger.severe("Error occurred: " + exception.getMessage());
			exception.printStackTrace();
	    }
	}
	
	public void handleGetNEmployeeRelations(Statement statement, Scanner reader) throws CustomException, SQLException {
		logger.info("Enter the column that needs to be ordered : ");
		String column = reader.nextLine();
		logger.info("Enter whether it should be asc or desc : ");
		String order = reader.nextLine();
		logger.info("Enter the limit");
		int n = reader.nextInt();
		List<Integer> employeeIds = new ArrayList<>();
		ResultSet resultSet = sqltask.getNCustomRecords(statement, n, column, order);
		while (resultSet.next()) {
            int employeeID = resultSet.getInt("EMPLOYEE_ID");
            employeeIds.add(employeeID);
        }
		for(int employeeId : employeeIds) {
			ResultSet resultSetRelations = sqltask.getData(statement, "EMPLOYEE_ID", employeeId, "EmployeeRelations");
            handlePrintRelation(resultSetRelations);
		}
	}
	
	public void handleGetEmployeeRelations(Statement statement, Scanner reader) throws CustomException, SQLException {
		logger.info("Enter the column of the employee : ");
		String column = reader.next();
		logger.info("Enter the value : ");
		String value = reader.next();
		List<Integer> employeeIds = new ArrayList<>();
		ResultSet resultSet = sqltask.getData(statement, column, value, "Employee");
        while (resultSet.next()) {
            int employeeID = resultSet.getInt("EMPLOYEE_ID");
            employeeIds.add(employeeID);
        }
		for(int employeeId : employeeIds) {
			ResultSet resultSetRelations = sqltask.getData(statement, "EMPLOYEE_ID", employeeId, "EmployeeRelations");
            handlePrintRelation(resultSetRelations);
		}
	}
	
	public void handleDelete(Statement statement, Scanner reader) throws CustomException, SQLException {
		logger.info("Enter the column of the employee : ");
		String column = reader.next();
		logger.info("Enter the value : ");
		String value = reader.next();
		sqltask.deleteEmployee(statement, column, value);
		handleNrecords(statement, reader);
	}
	
	public void handleNCustomRecords(Statement statement, Scanner reader) throws CustomException, SQLException {
		logger.info("Enter the column that needs to be ordered : ");
		String column = reader.nextLine();
		logger.info("Enter whether it should be asc or desc : ");
		String order = reader.nextLine();
		logger.info("Enter the limit");
		int n = reader.nextInt();
		
		ResultSet resultSet = sqltask.getNCustomRecords(statement, n, column, order);
		handlePrint(resultSet);
	}
	
	public void handleNrecords(Statement statement, Scanner reader) throws CustomException, SQLException {
		int n = reader.nextInt();
		ResultSet resultSet = sqltask.getNrecords(statement, n);
		handlePrint(resultSet);
	}
	
	public void handleUpdateEmployee(Statement statement, Scanner reader) throws CustomException, SQLException {
		logger.info("Enter the column that needs to be updated : ");
		String column = reader.nextLine();
		logger.info("Enter the updated value : ");
		String updatedValue = reader.nextLine();
		
		logger.info("Enter the matching column : ");
		String mathcingColumn = reader.nextLine();
		logger.info("Enter the value : ");
		String matchingValue = reader.nextLine();
		sqltask.updateEmployee(statement, column, mathcingColumn, updatedValue, matchingValue);
	}
	
	public void handleGetData(Statement statement, Scanner reader) throws CustomException, SQLException {
		logger.info("Enter the table : ");
		String table = reader.next();
		logger.info("Enter the column of the employee : ");
		String column = reader.next();
		logger.info("Enter the value : ");
		String value = reader.next();
		ResultSet resultSet = sqltask.getData(statement, column, value, table);
		handlePrint(resultSet);
	}
	
	public void handlePrint(ResultSet resultSet) throws SQLException {
		List<Employee> employees = new ArrayList<>();
		while(resultSet.next()) {
			Employee employee = new Employee(
					resultSet.getInt("EMPLOYEE_ID"),
					resultSet.getString("NAME"),
					resultSet.getString("MOBILE"),
					resultSet.getString("EMAIL"),
					resultSet.getString("DEPARTMENT")
            );
			employees.add(employee);
		}
		logger.info(employees.toString());
	}
	
	public void handlePrintRelation(ResultSet resultSet) throws SQLException {
		List<EmployeeRelation> employeerRelations = new ArrayList<>();
		while(resultSet.next()) {
			EmployeeRelation employee = new EmployeeRelation(
					resultSet.getInt("RELATION_ID"),
					resultSet.getInt("EMPLOYEE_ID"),
					resultSet.getString("NAME"),
					resultSet.getInt("AGE"),
					resultSet.getString("RELATIONSHIP")
            );
			employeerRelations.add(employee);
		}
		logger.info(employeerRelations.toString());
	}
	
	public void handleAddData(Statement statement, Scanner reader) throws CustomException, SQLException {
		logger.info("Enter the number of entries : ");
		int entries = reader.nextInt();
		reader.nextLine();
		while (entries --> 0) {
			logger.info("Enter the id : ");
			int id = reader.nextInt();
			reader.nextLine();
			logger.info("Enter the name : ");
			String name = reader.nextLine();
			logger.info("Enter the mobile number : ");
			String number = reader.nextLine();
			logger.info("Enter the email : ");
			String email = reader.nextLine();
			logger.info("Enter the department : ");
			String department = reader.nextLine();
			Employee employee = new Employee(id, name, number, email, department);
			sqltask.insertEmployee(statement, employee);
		}
	}
	
	public void handleAddDataRelations(Statement statement, Scanner reader) throws CustomException, SQLException {
		logger.info("Enter the number of entries : ");
		int entries = reader.nextInt();
		reader.nextLine();
		while (entries --> 0) {
			logger.info("Enter the relation id : ");
			int relationId = reader.nextInt();
			logger.info("Enter the employee id : ");
			int employeeId = reader.nextInt();
			logger.info("Enter the age : ");
			int age = reader.nextInt();
			reader.nextLine();
			logger.info("Enter the name : ");
			String name = reader.nextLine();
			logger.info("Enter the relationship : ");
			String relationship = reader.nextLine();
			EmployeeRelation employeeRelation = new EmployeeRelation(relationId, employeeId, name, age, relationship);
			sqltask.insertEmployeeRelation(statement, employeeRelation);
		}
	}
	
	public void handleCreateTableRelation(Statement statement) throws CustomException, SQLException {
		
		String createTableQuery = "CREATE TABLE IF NOT EXISTS EmployeeRelations (" +
            "RELATION_ID INT NOT NULL AUTO_INCREMENT, " +
            "EMPLOYEE_ID INT NOT NULL," +
            "NAME VARCHAR(100), " +
            "AGE INT, " +
            "RELATIONSHIP VARCHAR(100), " +
            "PRIMARY KEY (RELATION_ID), " +
            "FOREIGN KEY (EMPLOYEE_ID) REFERENCES Employee(EMPLOYEE_ID)" + 
            ");";
		sqltask.execute(statement, createTableQuery);
	}
	
	public void handleCreateTable(Statement statement) throws CustomException, SQLException {
		
		String createTableQuery = "CREATE TABLE IF NOT EXISTS Employee (" +
            "EMPLOYEE_ID INT NOT NULL AUTO_INCREMENT, " +
            "NAME VARCHAR(100), " +
            "MOBILE VARCHAR(10), " +
            "EMAIL VARCHAR(100), " +
            "DEPARTMENT VARCHAR(50), " +
            "PRIMARY KEY (EMPLOYEE_ID)" + 
            ");";
		sqltask.execute(statement, createTableQuery);
	}
}