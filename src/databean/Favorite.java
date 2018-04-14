package databean;


import org.genericdao.PrimaryKey;

@PrimaryKey("id")
public class Favorite {
    private int id;
    private int blogid;
    private String email;

    public int getId() {return id;}
    public int getBlogid() {return blogid;}
    public String getEmail() {return email;}

    public void setId(int id) {
        this.id = id;
    }

    public void setBlogid(int blogid) {
        this.blogid = blogid;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
