package hu.ulyssys.java.course.javaee.demo.service.impl;

import hu.ulyssys.java.course.javaee.demo.entity.AbstractBlog;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBlogService<T extends AbstractBlog> {

    private List<T> list = new ArrayList<>();

    public List<T> getAll() {
        return list;
    }

    public void add(T currentBlogElement) {
        list.add(currentBlogElement);
    }

    public void remove(T currentBlogElement) {
        list.remove(currentBlogElement);
    }
}
