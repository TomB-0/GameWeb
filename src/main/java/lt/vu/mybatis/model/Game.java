package lt.vu.mybatis.model;

public class Game {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.GAME.ID
     *
     * @mbg.generated Thu Apr 06 15:36:56 EEST 2023
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.GAME.TITLE
     *
     * @mbg.generated Thu Apr 06 15:36:56 EEST 2023
     */
    private String title;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.GAME.ID
     *
     * @return the value of PUBLIC.GAME.ID
     *
     * @mbg.generated Thu Apr 06 15:36:56 EEST 2023
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.GAME.ID
     *
     * @param id the value for PUBLIC.GAME.ID
     *
     * @mbg.generated Thu Apr 06 15:36:56 EEST 2023
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.GAME.TITLE
     *
     * @return the value of PUBLIC.GAME.TITLE
     *
     * @mbg.generated Thu Apr 06 15:36:56 EEST 2023
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.GAME.TITLE
     *
     * @param title the value for PUBLIC.GAME.TITLE
     *
     * @mbg.generated Thu Apr 06 15:36:56 EEST 2023
     */
    public void setTitle(String title) {
        this.title = title;
    }
}