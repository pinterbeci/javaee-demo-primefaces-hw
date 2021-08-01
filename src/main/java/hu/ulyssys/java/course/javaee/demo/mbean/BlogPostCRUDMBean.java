package hu.ulyssys.java.course.javaee.demo.mbean;

import hu.ulyssys.java.course.javaee.demo.entity.BlogPost;
import hu.ulyssys.java.course.javaee.demo.service.BlogPostService;
import hu.ulyssys.java.course.javaee.demo.service.impl.AbstractBlogService;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Named
@ViewScoped
public class BlogPostCRUDMBean implements Serializable {
    //like dog

    private List<BlogPost> list;
    private BlogPost selecteBlogPost;

    private boolean inFunction;

    private BlogPostService blogPostService;

    @Inject
    public BlogPostCRUDMBean(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
        list = blogPostService.getAll();
        selecteBlogPost = new BlogPost();
    }

    public void save() {
        if (selecteBlogPost.getId() == null) {
            selecteBlogPost.setId(System.currentTimeMillis());
            selecteBlogPost.setCreatedDate(new Date());
            blogPostService.add(selecteBlogPost);
            list = blogPostService.getAll();
            selecteBlogPost = new BlogPost();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres hozzáadás"));
        } else {
            blogPostService.update(selecteBlogPost);
            list = blogPostService.getAll();
            selecteBlogPost = new BlogPost();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres módosítás"));
        }
    }

    public void remove() {

        blogPostService.remove(selecteBlogPost);
        list = blogPostService.getAll();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres törlés"));
    }

    public void initSave() {
        selecteBlogPost = new BlogPost();
        inFunction = true;
    }

    public void initEdit() {
        inFunction = true;
    }


    public List<BlogPost> getList() {
        return list;
    }

    public void setList(List<BlogPost> list) {
        this.list = list;
    }

    public BlogPost getSelecteBlogPost() {
        return selecteBlogPost;
    }

    public void setSelecteBlogPost(BlogPost selecteBlogPost) {
        this.selecteBlogPost = selecteBlogPost;
    }

    public boolean isInFunction() {
        return inFunction;
    }

    public void setInFunction(boolean inFunction) {
        this.inFunction = inFunction;
    }
}
