package databean;

import org.genericdao.PrimaryKey;

import java.util.Date;

@PrimaryKey("id")
public class Blog {
    private int id;
    private Date date;
    private String author;
    private String email;
    private String content;

    public int getId() {
        return id;
    }
    public Date getDate() {
        return date;
    }

    public String getAuthor() {
        return author;
    }
    public String getEmail() {
        return email;
    }
    public String getContent() {
        return content;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
