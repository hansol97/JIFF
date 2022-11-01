package com.kh.model.vo;

public class Movie {
    
    private int movieNo;
    private String title;
    private String genre;
    private int rating;
    
    public Movie() {
        super();
    }
    
    public Movie(int movieNo, String title, String genre, int rating) {
        super();
        this.movieNo = movieNo;
        this.title = title;
        this.genre = genre;
        this.rating = rating;
    }
    public int getMovieNo() {
        return movieNo;
    }
    public void setMovieNo(int movieNo) {
        this.movieNo = movieNo;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    
    @Override
    public String toString() {
        return "Movie [영화 번호=" + movieNo + ", 영화제목=" + title + ", 장르=" + genre + ", 등급 =" + rating + "]";
    }
    
    

}
