package hu.ulyssys.java.course.javaee.demo.service;

import hu.ulyssys.java.course.javaee.demo.entity.AbstractBlog;

import java.util.List;

public interface CoreService<T extends AbstractBlog> {

    List<T> getAll();

    void add(T blogElement);

    void remove(T blogElement);
}
