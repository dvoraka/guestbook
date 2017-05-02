package local.company.guestbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "AUTHOR")
public class Author {

    private static final int MIN_USERNAME_LENGTH = 3;
    private static final int MAX_USERNAME_LENGTH = 20;

    @Id
    @GeneratedValue
    private Long id;

    @Size(min = MIN_USERNAME_LENGTH, max = MAX_USERNAME_LENGTH)
    private String name;
    private String password;
    private Instant created;

    @OneToMany(mappedBy = "author")
    private List<Comment> comments = new ArrayList<>();


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Author author = (Author) o;

        if (name != null ? !name.equals(author.name) : author.name != null) {
            return false;
        }
        if (password != null ? !password.equals(author.password) : author.password != null) {
            return false;
        }
        if (created != null ? !created.equals(author.created) : author.created != null) {
            return false;
        }

        return comments != null ? comments.equals(author.comments) : author.comments == null;

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = name != null ? name.hashCode() : 0;
        result = prime * result + (password != null ? password.hashCode() : 0);
        result = prime * result + (created != null ? created.hashCode() : 0);
        result = prime * result + (comments != null ? comments.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "Author {" +
                "id=" + id +
                ", username='" + name + '\'' +
                ", password='" + password + '\'' +
                ", created=" + created +
                ", comments=" + comments +
                '}';
    }
}
