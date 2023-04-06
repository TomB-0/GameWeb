package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.mybatis.dao.GameMapper;
import lt.vu.mybatis.model.Game;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class GamesMyBatis {

    @Inject
    private GameMapper gameMapper;

    @Getter
    private List<Game> allGames;

    @Getter
    @Setter
    private Game gameToCreate = new Game();

    @PostConstruct
    public void init() {this.loadAllGames();}

    private void loadAllGames(){this.allGames = gameMapper.selectAll();}

    @Transactional
    public String createGame(){
        gameMapper.insert(gameToCreate);
        return "/myBatis/games?faces-redirect=true";
    }
}
