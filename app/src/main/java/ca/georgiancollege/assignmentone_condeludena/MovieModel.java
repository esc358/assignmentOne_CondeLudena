/*
 * Emilio Sebastian Conde Ludena
 * 200478144
 * July 20, 2025
 * 2:36pm
 * */

package ca.georgiancollege.assignmentone_condeludena;

//Class contains field and behaviour for the MovieModel based on ExampleTitle.json
public class MovieModel {
    //fields for the movie
    private String title;
    private String studio;
    private String ratingValue;
    private String year;
    private String poster;
    private String released;
    private String runTime;
    private String director;
    private String actors;
    private String plot;

    //getters and setters for the fields
    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(String ratingValue) {
        this.ratingValue = ratingValue;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
