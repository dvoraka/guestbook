package local.company.guestbook.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;

/**
 * Topic group entity.
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "TOPIC_GROUP")
public class TopicGroup {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;
    @NotNull
    private Instant created;

    @OneToMany(mappedBy = "topicGroup")
    private List<Topic> topics;
}
