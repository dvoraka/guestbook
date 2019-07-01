package local.company.guestbook.model;

import lombok.Data;

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
 * Comment entity.
 */
@Data
@Entity
@Table(name = "COMMENT")
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String text;
    @NotNull
    private Instant created;

    @ManyToOne(optional = false)
    private Author author;

    @OneToMany(mappedBy = "comment")
    private List<Vote> votes;
}
