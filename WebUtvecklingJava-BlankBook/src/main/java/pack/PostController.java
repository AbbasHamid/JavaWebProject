package pack;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DAO.PostDAOimp;
import entity.Post;


@WebServlet("/PostController")
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	PostDAOimp postdao = null;
	
	
   
    public PostController() {
       
    	postdao = new PostDAOimp();
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
	//Hämtar värdet för action som följer med länken
	String action = req.getParameter("action");
	
	if (action == null) {
		action = "LIST";
	}
	
	
	switch (action) {
	case "LIST": {
		listPost(req,resp);
	break;
	}
	case "EDIT": {
		getSinglePost(req,resp);
	break;
	}case "DELETE": {
		deletePost(req,resp);
	break;
	}
	default:
		listPost(req,resp);
		break;
	}
	
	
	}
	
	
	

	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");	
		String post = request.getParameter("post");	
		String tag = request.getParameter("tag");
		Post p =  new Post();
		
		//Skapar ett objekt som sedan skicka till data basen beronde på om det är EDIT eller ADD
		p.setPost(post);
		p.setTag(tag);
        
        
        if (id == null || id.isEmpty()) {
        	 if (postdao.save(p)) {
             	request.setAttribute("message", "ADDED SUCCESSFULLY!");
     		}
		}else {
			p.setId(Integer.parseInt(id));
			if (postdao.update(p)) {
	        	request.setAttribute("message", "UPDATED SUCCESSFULLY!");
			}
		}
        
        
       
        listPost(request,response);
		
		
	}
	
	
	//Function för att lista alla posts
	public void listPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Post> PostList =  postdao.get();
	    req.setAttribute("PostList", PostList);
		req.getRequestDispatcher("/views/post-list.jsp").forward(req, resp);
	}
	
	
	
	//Function för att hämta en specifik post och skicka den till viewn
	private void getSinglePost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		Post post =  postdao.get(Integer.parseInt(id));
		
		req.setAttribute("post", post);
		req.getRequestDispatcher("/views/post-add.jsp").forward(req, resp);
		
	}
	
	
	
	//Function för att ta bort post. Denna skicka id för den post som skall bort.
	private void deletePost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id=req.getParameter("id");
		postdao.delete(Integer.parseInt(id));
		req.setAttribute("message", "DELETED SUCCESSFULLY!");
		 listPost(req,resp);
		
	}
	
	
	
	
	
	
	
}
