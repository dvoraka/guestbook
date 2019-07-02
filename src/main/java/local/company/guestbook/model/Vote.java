package local.company.guestbook.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Vote entity. For a {@link Topic} and {@link Comment} voting.
 */
@Data
@Entity
@Table(name = "VOTE")
public class Vote {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Author author;

    @ManyToOne
    private Comment comment;
}
