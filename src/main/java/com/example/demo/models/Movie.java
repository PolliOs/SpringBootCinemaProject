package com.example.demo.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Set;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    @NotNull
    private String movieTitle;

    @Column(name = "year")
    @NotNull
    private Integer year;

    @Column(name = "duration")
    @NotNull
    private Integer duration;

    @ManyToMany
    @JoinTable(
            name="genres_of_movie",
            joinColumns = @JoinColumn(name="movie_id"),
            inverseJoinColumns = @JoinColumn(name="genre_id")
    )
    Set<Genre> genresOfMovie;

    @OneToMany(mappedBy="movie")
    private Set<Session> sessions;


    /**
     * @return the genresOfMovie
     */

    public Set<Genre> getGenresOfMovie() {
        return genresOfMovie;
    }

    /**
     * @param genresOfMovie the genresOfMovie to set
     */
    public void setGenresOfMovie(Set<Genre> genresOfMovie) {
        this.genresOfMovie = genresOfMovie;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the movieTitle
     */
    public String getMovieTitle() {
        return movieTitle;
    }

    /**
     * @param movieTitle the movieTitle to set
     */
    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    /**
     * @return the year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */

    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * @return the duration
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((movieTitle == null) ? 0 : movieTitle.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + (year == null ? 0 : year.hashCode());
        result = prime * result + ((duration == null) ? 0 : duration.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Movie other = (Movie) obj;
        if (movieTitle == null) {
            if (other.movieTitle != null)
                return false;
        } else if (!movieTitle.equals(other.movieTitle))
            return false;
        if (id == null) {
            return other.id == null;
        }else if (!id.equals(other.id))
            return false;
        if (year == null) {
            return other.year == null;
        }else if (!year.equals(other.year))
            return false;
        if (duration == null) {
            return other.duration == null;
        }else return duration.equals(other.duration);
    }

    public Set<Session> getSessions() {
        return sessions;
    }

    public void setSessions(Set<Session> sessions) {
        this.sessions = sessions;
    }
}


