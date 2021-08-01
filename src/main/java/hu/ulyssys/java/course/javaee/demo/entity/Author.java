package hu.ulyssys.java.course.javaee.demo.entity;

import java.util.Date;

public class Author extends AbstractBlog {

    private String firstName;
    private String lastName;
    private String userName;
    private Date createdDate;
    private Date lastModifiedDate;

    public Author() {
    }

    public Author(Long id, Date createdDate, Date lastModifiedDate, String firstName, String lastName, String userName, Date createdDate1, Date lastModifiedDate1) {
        super(id, createdDate, lastModifiedDate);
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.createdDate = createdDate1;
        this.lastModifiedDate = lastModifiedDate1;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public Date getCreatedDate() {
        return createdDate;
    }

    @Override
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    @Override
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
