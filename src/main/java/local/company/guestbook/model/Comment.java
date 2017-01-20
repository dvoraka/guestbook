package local.company.guestbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "COMMENT")
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    private String text;
    private Instant created;

    @ManyToOne
    private Author author;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant date) {
        this.created = date;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Comment comment = (Comment) o;

        if (text != null ? !text.equals(comment.text) : comment.text != null) {
            return false;
        }
        if (created != null ? !created.equals(comment.created) : comment.created != null) {
            return false;
        }

        return author != null ? author.equals(comment.author) : comment.author == null;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = text != null ? text.hashCode() : 0;
        result = prime * result + (created != null ? created.hashCode() : 0);
        result = prime * result + (author != null ? author.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", created=" + created +
                ", user=" + author +
                '}';
    }
}
