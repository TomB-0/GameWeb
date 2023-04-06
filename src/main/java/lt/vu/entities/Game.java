package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Game.findAll", query = "select g from Game as g")
})
@Table(name = "GAME")
@Getter
@Setter
public class Game {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private String title;


    @OneToMany(mappedBy = "game")
    private List<Review> reviews = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "GAME_PUBLISHER",
            joinColumns = {@JoinColumn(name = "publisher_id")},
            inverseJoinColumns = {@JoinColumn(name = "game_id")}
    )
    private List<Publisher> publishers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(title, game.title);
    }

    public Game(){

    }

}
