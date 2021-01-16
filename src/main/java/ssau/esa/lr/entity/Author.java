package ssau.esa.lr.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Table(schema = "public", name = "author")
public class Author {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "gender")
    private String gender;
    @JsonIgnore
    @OneToMany(mappedBy = "author")
    private List<Book> book;

    public Author(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id &&
                Objects.equals(name, author.name) &&
                Objects.equals(surname, author.surname)&&
                Objects.equals(gender, author.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, gender);
    }

    @Override
    public String toString() {
        return String.format("%s %s", name, surname);
    }
}
