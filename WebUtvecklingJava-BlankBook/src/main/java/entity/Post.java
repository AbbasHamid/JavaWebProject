package entity;

public class Post {
	
	private int id;
	private String post;
	private String tag;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", post=" + post + ", tag=" + tag + "]";
	}
	
	
	
	
	
	
	

}
