package hu.ulyssys.java.course.javaee.demo.entity;

import java.util.Date;

public class BlogPost extends AbstractBlog {

    private String tittle;
    private String content;
    private TypeOfCategory category;
    private Date publishedDate;

    public BlogPost() {
    }

    public BlogPost(Long id, Date createdDate, Date lastModifiedDate, String tittle, String content, TypeOfCategory category, Date publishedDate) {
        super(id, createdDate, lastModifiedDate);
        this.tittle = tittle;
        this.content = content;
        this.category = category;
        this.publishedDate = publishedDate;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TypeOfCategory getCategory() {
        return category;
    }

    public void setCategory(TypeOfCategory category) {
        this.category = category;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }
}
