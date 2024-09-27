package tasks;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import exception.CustomException;
import helper.util.Helper;
import pojo.Employee;
import pojo.EmployeeRelation;

public class SqlTask {
	
	public ResultSet executeQuery(Statement statement, String sqlQuery) throws CustomException, SQLException {
		Helper.checkNullValues(sqlQuery);
		Helper.checkNullValues(statement);
		return statement.executeQuery(sqlQuery);
	}
	
	public boolean execute(Statement statement, String sqlQuery) throws CustomException, SQLException {
		Helper.checkNullValues(sqlQuery);
		Helper.checkNullValues(statement);
		return statement.execute(sqlQuery);
	}
	
	public ResultSet getNrecords(Statement statement, int n) throws CustomException, SQLException {
		Helper.checkNullValues(n);
		String getEmployeeQuery = "SELECT * FROM Employee LIMIT " + n + ";";
		return executeQuery(statement, getEmployeeQuery);
	}
	
	public <T> ResultSet getData(Statement statement, String column,  T value, String table) throws CustomException, SQLException {
		Helper.checkNullValues(value);
		Helper.checkNullValues(column);
		Helper.checkNullValues(table);
		String getEmployeeQuery = "SELECT * FROM " + table + " WHERE " + column + " = '"+ value + "';";
		return executeQuery(statement, getEmployeeQuery);
	}

	public void deleteEmployee(Statement statement, String column,  String value) throws CustomException, SQLException {
		Helper.checkNullValues(value);
		String getEmployeeQuery = "DELETE FROM Employee WHERE " + column + " = '"+ value + "';";
		execute(statement, getEmployeeQuery);
	}
	
	public void insertEmployee(Statement statement, Employee employee) throws CustomException, SQLException {
		int id = employee.getEmployeeId();
		String name = employee.getName(), number = employee.getMobile(), email = employee.getEmail(), department = employee.getDepartment();
		Helper.checkNullValues(id);
		Helper.checkNullValues(name);
		Helper.checkNumber(number);
		Helper.checkEmail(email);
		Helper.checkNullValues(department);
		
		String addDataQuery = "INSERT INTO Employee VALUES (" + id + "'" + name + "', '" + number + "', '" + email + "', '" + department + "');";
		execute(statement, addDataQuery);
	}
	
	public void insertEmployeeRelation(Statement statement, EmployeeRelation employeeRelation) throws CustomException, SQLException {
		int employeeId = employeeRelation.getEmployeeId(), relationId = employeeRelation.getRelationId(), age = employeeRelation.getAge();
		String name = employeeRelation.getName(), relationship = employeeRelation.getRelationship();
		Helper.checkNullValues(employeeId);
		Helper.checkNullValues(name);
		Helper.checkNullValues(relationId);
		Helper.checkNullValues(age);
		Helper.checkNullValues(relationship);
		
		String addDataQuery = "INSERT INTO EmployeeRelations VALUES (" + relationId + ", " + employeeId +  ", '" + name + "', '" + age + "', '" + relationship + "');";
		execute(statement, addDataQuery);
	}
	
	public ResultSet getNCustomRecords(Statement statement, int n, String column, String order) throws CustomException, SQLException {
		Helper.checkNullValues(n);
		Helper.checkNullValues(column);
		Helper.checkNullValues(order);
		String getEmployeeQuery = "SELECT * FROM Employee ORDER BY " + column + " " + order + " LIMIT " + n + ";";
		return executeQuery(statement, getEmployeeQuery);
	}
	
	public void updateEmployee(Statement statement, String column, String matchingColumn, String updatedValue, String matchingValue) throws CustomException, SQLException {
		Helper.checkNullValues(column);
		Helper.checkNullValues(matchingColumn);
		Helper.checkNullValues(updatedValue);
		Helper.checkNullValues(matchingValue);
		
		String updateQuery = "UPDATE Employee SET " + column + " = '" + updatedValue + "' WHERE " + matchingColumn + " = '" + matchingValue + "';";
		execute(statement, updateQuery);
	}
}
