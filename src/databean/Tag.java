package databean;

import org.genericdao.PrimaryKey;

@PrimaryKey("id")
public class Tag {
    private int id;
    private int blogid;
    private String tagname;
    private String email;

    public int getId() {
        return id;
    }

    public  int getBlogid() {
        return blogid;
    }

    public String getTagname() {
        return tagname;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBlogid(int blogid) {
        this.blogid = blogid;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
