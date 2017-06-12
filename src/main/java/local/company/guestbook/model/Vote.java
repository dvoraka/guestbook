package local.company.guestbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Vote entity.
 */
@Entity
@Table(name = "VOTE")
public class Vote {

    @Id
    @GeneratedValue
    private Long id;

    private boolean positive;

    @ManyToOne
    private Author author;

    @ManyToOne
    private Comment comment;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPositive() {
        return positive;
    }

    public void setPositive(boolean positive) {
        this.positive = positive;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", positive=" + positive +
                ", author=" + author.getName() +
                ", comment=" + comment.getText() +
                '}';
    }
}
