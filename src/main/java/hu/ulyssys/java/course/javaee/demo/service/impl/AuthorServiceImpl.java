package hu.ulyssys.java.course.javaee.demo.service.impl;

import hu.ulyssys.java.course.javaee.demo.entity.Author;
import hu.ulyssys.java.course.javaee.demo.entity.BlogPost;
import hu.ulyssys.java.course.javaee.demo.service.AuthorService;

import javax.enterprise.context.ApplicationScoped;
import java.util.Date;

@ApplicationScoped
public class AuthorServiceImpl extends AbstractBlogService<Author> implements AuthorService {


    public AuthorServiceImpl() {

        for (int i = 0; i < 100; i++) {

            Author author = new Author();
            author.setId(Long.parseLong(Integer.toString(i + 100)));
            author.setCreatedDate(new Date());
            author.setFirstName("Author FN-" + i);
            author.setLastName("Author LN-" + i);
            author.setUserName("Author UN-" + i);
            author.setLastModifiedDate(null);
            add(author);
        }
    }

    @Override
    public void update(Author currentAuthor) {
        for (Author author : getAll()
        ) {
            if (author.getId().equals(currentAuthor.getId())) {
                author.setFirstName(currentAuthor.getFirstName());
                author.setLastName(currentAuthor.getLastName());
                author.setUserName(currentAuthor.getUserName());
                author.setCreatedDate(currentAuthor.getCreatedDate());
                author.setLastModifiedDate(new Date());
            }
        }
    }
}
