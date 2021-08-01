package hu.ulyssys.java.course.javaee.demo.service;

import hu.ulyssys.java.course.javaee.demo.entity.Author;

public interface AuthorService extends CoreService<Author> {

    void update(Author currentAuthor);
}
