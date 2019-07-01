package local.company.guestbook.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

/**
 * Author entity.
 */
@Data
@Entity
@Table(name = "AUTHOR")
public class Author {

    private static final int MIN_USERNAME_LENGTH = 3;
    private static final int MAX_USERNAME_LENGTH = 20;

    @Id
    @GeneratedValue
    private Long id;

    @Size(min = MIN_USERNAME_LENGTH, max = MAX_USERNAME_LENGTH)
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Instant created;

    @OneToMany(mappedBy = "author")
    private Set<Comment> comments;

    @OneToMany(mappedBy = "author")
    private Set<Vote> votes;


    public Author() {
        comments = new HashSet<>();
        votes = new HashSet<>();
    }
}
