package pack;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DAO.EmployeeDAOimp;
import entity.Employee;


@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	EmployeeDAOimp employeedao = null;
	
   
    public EmployeeController() {
       
    	employeedao = new EmployeeDAOimp();
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	String action = req.getParameter("action");
	
	if (action == null) {
		action = "LIST";
	}
	
	
	switch (action) {
	case "LIST": {
		listEmployees(req,resp);
	break;
	}
	case "EDIT": {
		getSingleEmployee(req,resp);
	break;
	}case "DELETE": {
		deleteEmployee(req,resp);
	break;
	}
	default:
		listEmployees(req,resp);
		break;
	}
	
	
	}
	
	
	

	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");	
		String name = request.getParameter("name");		
		String dob= request.getParameter("date");
		String departement = request.getParameter("Departement");
		Employee e =  new Employee();
		
	
		e.setName(name);
		e.setDepartement(departement);
        e.setDob(dob);
        
        if (id == null || id.isEmpty()) {
        	 if (employeedao.save(e)) {
             	request.setAttribute("message", "ADDED SUCCESSFULLY!");
     		}
		}else {
			e.setId(Integer.parseInt(id));
			if (employeedao.update(e)) {
	        	request.setAttribute("message", "UPDATED SUCCESSFULLY!");
			}
		}
        
        
       
        listEmployees(request,response);
		
		
	}
	
	
	
	public void listEmployees(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Employee> EmployeeList =  employeedao.get();
	    req.setAttribute("EmployeeList", EmployeeList);
		req.getRequestDispatcher("/views/Employee-list.jsp").forward(req, resp);
	}

	private void getSingleEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		Employee employee =  employeedao.get(Integer.parseInt(id));
		
		req.setAttribute("employee", employee);
		req.getRequestDispatcher("/views/employee-add.jsp").forward(req, resp);
		
	}
	
	
	private void deleteEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		employeedao.delete(Integer.parseInt(id));
		req.setAttribute("message", "DELETED SUCCESSFULLY!");
		 listEmployees(req,resp);
		
	}
	
	
	
	
	
	
	
}
