package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Game;
import lt.vu.entities.Review;
import lt.vu.persistence.GamesDAO;
import lt.vu.persistence.ReviewsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Map;

@Model
public class ReviewsForGame {

    @Inject
    private GamesDAO gamesDAO;

    @Inject
    private ReviewsDAO reviewsDAO;

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
        this.game = gamesDAO.findOne(gameId);
    }

    @Transactional
    public void createReview() {
        reviewToCreate.setGame(this.game);
        reviewsDAO.persist(reviewToCreate);
    }


}
