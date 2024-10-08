package pojo;

public class Employee {
    private int employeeId;
    private String name;
    private String mobile;
    private String email;
    private String department;

    public Employee() {}

    public Employee(int employeeId, String name, String mobile, String email, String department) {
        this.employeeId = employeeId;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.department = department;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

    public String toString() {
        return "Employee { " +
                "EMPLOYEE_ID: " + employeeId +
                ", NAME: '" + name + '\'' +
                ", MOBILE: '" + mobile + '\'' +
                ", EMAIL: '" + email + '\'' +
                ", DEPARTMENT: '" + department + '\'' +
                " }";
    }
}
