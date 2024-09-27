package pojo;

public class EmployeeRelation {
    private int relationId;       
    private int employeeId;       
    private String name;          
    private int age;              
    private String relationship;   

    public EmployeeRelation() {}

 
    public EmployeeRelation(int relationId, int employeeId, String name, int age, String relationship) {
        this.relationId = relationId;
        this.employeeId = employeeId;
        this.name = name;
        this.age = age;
        this.relationship = relationship;
    }

    public int getRelationId() {
        return relationId;
    }

    public void setRelationId(int relationId) {
        this.relationId = relationId;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String toString() {
        return "EmployeeRelation{" +
                "relationId=" + relationId +
                ", employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", relationship='" + relationship + '\'' +
                '}';
    }
}
