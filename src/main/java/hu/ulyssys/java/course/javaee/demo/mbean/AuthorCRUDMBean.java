package hu.ulyssys.java.course.javaee.demo.mbean;

import hu.ulyssys.java.course.javaee.demo.entity.Author;
import hu.ulyssys.java.course.javaee.demo.service.AuthorService;

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
public class AuthorCRUDMBean implements Serializable {

    //like the cat

    private List<Author> list;
    private Author selectedAuthor;

    private boolean inFunction;

    private AuthorService authorService;

    @Inject
    public AuthorCRUDMBean(AuthorService authorService) {
        this.authorService = authorService;
        list = authorService.getAll();
        selectedAuthor = new Author();
        //TODO list= authoservice.getall()
    }

    public void initSave() {
        selectedAuthor = new Author();
        inFunction = true;
    }

    public void initEdit(Author currentAuthor) {
        selectedAuthor = currentAuthor;
        inFunction = true;
    }

    public void remove(Author author) {
        authorService.remove(author);
        list = authorService.getAll();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres törlés"));
    }

    public void save() {

        if (selectedAuthor.getId() == null) {
            selectedAuthor.setId(System.currentTimeMillis());
            selectedAuthor.setCreatedDate(new Date());
            authorService.add(selectedAuthor);
            list = authorService.getAll();
            selectedAuthor = new Author();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres mentés!"));
        } else {
            authorService.update(selectedAuthor);
            list = authorService.getAll();
            selectedAuthor = new Author();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres módosítás!"));
        }

        inFunction = false;
    }

    public List<Author> getList() {
        return list;
    }

    public void setList(List<Author> list) {
        this.list = list;
    }

    public Author getSelectedAuthor() {
        return selectedAuthor;
    }

    public void setSelectedAuthor(Author selectedAuthor) {
        this.selectedAuthor = selectedAuthor;
    }

    public boolean isInFunction() {
        return inFunction;
    }

    public void setInFunction(boolean inFunction) {
        this.inFunction = inFunction;
    }

}
