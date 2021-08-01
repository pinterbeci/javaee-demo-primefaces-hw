package hu.ulyssys.java.course.javaee.demo.service;

import hu.ulyssys.java.course.javaee.demo.entity.BlogPost;

public interface BlogPostService extends CoreService<BlogPost> {

    void update(BlogPost currentBlogPost);
}
