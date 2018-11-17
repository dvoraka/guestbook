package local.company.guestbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;

/**
 * Topic entity.
 */
@Entity
@Table(name = "TOPIC")
public class Topic {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;
    @NotNull
    private Instant created;

    @ManyToOne(optional = false)
    private Author author;

    @OneToMany(mappedBy = "topic")
    private List<Vote> votes;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Topic comment = (Topic) o;

        if (name != null ? !name.equals(comment.name) : comment.name != null) {
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
        int result = name != null ? name.hashCode() : 0;
        result = prime * result + (created != null ? created.hashCode() : 0);
        result = prime * result + (author != null ? author.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", text='" + name + '\'' +
                ", created=" + created +
                ", author=" + author.getName() +
                ", votes=" + votes +
                '}';
    }
}
