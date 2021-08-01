package hu.ulyssys.java.course.javaee.demo.service.impl;

import hu.ulyssys.java.course.javaee.demo.entity.BlogPost;
import hu.ulyssys.java.course.javaee.demo.entity.TypeOfCategory;
import hu.ulyssys.java.course.javaee.demo.service.BlogPostService;

import javax.enterprise.context.ApplicationScoped;
import java.util.Date;

@ApplicationScoped
public class BlogPostServiceImpl extends AbstractBlogService<BlogPost> implements BlogPostService {

    public BlogPostServiceImpl() {

        for (int i = 0; i < 100; i++) {

            BlogPost blogPost = new BlogPost();

            blogPost.setId(Long.parseLong(Integer.toString(i)));
            blogPost.setContent("Content-" + i);
            blogPost.setTittle("Title of BlogPost-" + i);
            blogPost.setPublishedDate(new Date());
            blogPost.setLastModifiedDate(null);
            blogPost.setCreatedDate(new Date());
            //random hajigálja a cuccot!!
            blogPost.setCategory(((i % 2) == 0) ? TypeOfCategory.JAVA :
                    ((i % 3) == 0) ? TypeOfCategory.MAVEN
                            : TypeOfCategory.SQL);
            add(blogPost);
        }
    }

    @Override
    public void update(BlogPost currentBlogPost) {

        for (BlogPost blogPost : getAll()
        ) {
            if (blogPost.getId().equals(currentBlogPost.getId())) {
                blogPost.setCategory(currentBlogPost.getCategory());
                blogPost.setCreatedDate(currentBlogPost.getCreatedDate());
                blogPost.setLastModifiedDate(new Date());
                blogPost.setCategory(currentBlogPost.getCategory());
                blogPost.setTittle(currentBlogPost.getTittle());

                //todo publicatedDate calendarral való beállítása
                blogPost.setContent(currentBlogPost.getContent());
            }
        }
    }
}
