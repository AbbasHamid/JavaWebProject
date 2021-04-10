package DAO;



import java.util.List;

import entity.Post;

public interface PostDAO {
	
	
	List<Post> get();
	
	boolean save(Post e);
	Post get(int id);
	boolean update(Post e);
	void delete(int id);
}
