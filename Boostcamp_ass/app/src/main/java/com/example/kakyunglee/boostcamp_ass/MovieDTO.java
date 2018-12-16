package com.example.kakyunglee.boostcamp_ass;

public class MovieDTO {

    private String title;
    private String link;
    private String image;
    private String pubDate;
    private String director;
    private String actor;
    private Double userRating;


    MovieDTO(){
        image = "";
        link ="";
        userRating = 0.0;
        director = "";
        actor = "";
        link = "";
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getUserRating() {
        return userRating;
    }

    public void setUserRating(Double userRating) {
        this.userRating = userRating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPubDate(){
        return pubDate;
    }

    public void setPubDate(String pubDate){
        this.pubDate = pubDate;
    }




}
