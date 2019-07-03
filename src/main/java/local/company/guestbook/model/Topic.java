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
import java.util.Set;

/**
 * Topic entity. The topic is logically part of a {@link TopicGroup}.
 */
@Data
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

    @OneToMany
    private Set<Vote> votes;

    @ManyToOne
    private TopicGroup topicGroup;
}
