package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Review.findAll", query = "select r from Review as r")
})
@Table(name = "REVIEW")
@Getter
@Setter
public class Review {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Size(max = 50)
    @Column(name = "NAME")
    private String name;

    @Column(name = "RATING")
    private Integer rating;

    @Size(max = 400)
    @Column(name = "CONTENT")
    private String content;

    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer version;

    public Review() {
    }

    @ManyToOne
    @JoinColumn(name="GAME_ID")
    private Game game;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(id, review.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
