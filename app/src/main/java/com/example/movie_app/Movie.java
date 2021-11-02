package com.example.movie_app;

public class Movie {
    private String name;
    private int budget;
    private double popularity;
    private String releaseDate;

    public Movie(String name, String releaseDate) {
        this.name = name;
        this.budget = budget;
        this.popularity = popularity;
        this.releaseDate = releaseDate;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", budget=" + budget +
                ", popularity=" + popularity +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }
}
