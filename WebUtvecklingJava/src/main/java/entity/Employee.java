package entity;

public class Employee {
	
	private int id;
	private String name;
	private String dob;	
	private String departement;
	
	
	
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dob=" + dob + ", departement=" + departement + "]";
	}
	
	
	
	
	
	
	

}
