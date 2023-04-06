package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.mybatis.dao.GameMapper;
import lt.vu.mybatis.dao.ReviewMapper;
import lt.vu.mybatis.model.Game;
import lt.vu.mybatis.model.Review;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Map;

@Model
public class ReviewsForGameMyBatis {

    @Inject
    private GameMapper gameMapper;

    @Inject
    private ReviewMapper reviewMapper;

    @Getter
    @Setter
    private Game game;

    @Getter
    @Setter
    private Review reviewToCreate = new Review();

    @PostConstruct
    public void init(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer gameId = Integer.parseInt(requestParameters.get("gameId"));
        this.game = gameMapper.selectByPrimaryKey(gameId);
    }

}
