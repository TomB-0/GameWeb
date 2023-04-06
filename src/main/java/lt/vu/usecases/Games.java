package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Game;
import lt.vu.entities.Publisher;
import lt.vu.persistence.GamesDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Games {

    @Inject
    private GamesDAO gamesDAO;

    @Getter
    @Setter
    private Game gameToCreate = new Game();

    @Getter
    private List<Game> allGames;

    @Getter
    private List<Publisher> allPublishers;

    @PostConstruct
    public void init() { loadAllGames(); }

    @Transactional
    public void createGame() {this.gamesDAO.persist(gameToCreate);}

    private void loadAllGames(){this.allGames = gamesDAO.loadAll();}
}
