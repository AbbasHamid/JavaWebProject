package DAO;



import java.util.List;

import entity.Employee;

public interface EmployeeDAO {
	
	
	List<Employee> get();
	
	boolean save(Employee e);
	Employee get(int id);
	boolean update(Employee e);
	void delete(int id);
}
