package databean;

import org.genericdao.PrimaryKey;

@PrimaryKey("id")
public class LikeDislike {
    private int id;
    private int blogid;
    /**
     * true means like, false means dislike
     */
    private boolean status;
    /**
     * the email for the source of like and dislike
     */
    private String email;

    public int getId() { return id; }
    public int getBlogid() {return blogid;}
    public boolean getStatus() {return status;}
    public String getEmail() { return email;}

    public void setId(int id) {
        this.id = id;
    }

    public void setBlogid(int blogid) {
        this.blogid = blogid;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
