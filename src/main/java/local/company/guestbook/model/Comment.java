package local.company.guestbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "COMMENT")
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    private String text;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @ManyToOne
    private User user;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date date) {
        this.created = date;
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

        return user != null ? user.equals(comment.user) : comment.user == null;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = text != null ? text.hashCode() : 0;
        result = prime * result + (created != null ? created.hashCode() : 0);
        result = prime * result + (user != null ? user.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", created=" + created +
                ", user=" + user +
                '}';
    }
}
