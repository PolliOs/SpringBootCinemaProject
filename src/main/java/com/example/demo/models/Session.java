package com.example.demo.models;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "sessions")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "time")
    @NotNull
    @DateTimeFormat(pattern = "HH:mm")
    private java.util.Date time;

    @Column(name = "day")
    @NotNull
    private String day;

    @Column(name = "price")
    @NotNull
    private Integer price;

    @ManyToOne
    @JoinColumn(name="movie_id", nullable=false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name="hall_id", nullable=false)
    private Hall hall;


    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *          the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the hall
     */
    public Hall getHall() {
        return hall;
    }

    /**
     * @param hall the hall to set
     */
    public void setHall(Hall hall) {
        this.hall = hall;
    }


    /**
     * @return the movie
     */
    public Movie getMovie() {
        return movie;
    }

    /**
     * @param movie the movie to set
     */
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    /**
     * @return the time
     */
    public java.util.Date getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(java.util.Date time) {
        this.time = time;
    }

    /**
     * @return the day
     */
    public String getDay() {
        return day;
    }

    /**
     * @param day the day to set
     */
    public void setDay(String day) {
        this.day = day;
    }


    /**
     * @return the price
     */
    public Integer getPrice() {
        return price;
    }
    /**
     * @param price the price to set
     */
    public void setPrice(Integer price) {
        this.price = price;
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
        result = prime * result + ((time == null) ? 0 : time.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + (day == null ? 0 : day.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
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
        Session other = (Session) obj;
        if (time == null) {
            if (other.time != null)
                return false;
        } else if (!time.equals(other.time))
            return false;
        if (id == null) {
            return other.id == null;
        }else if (!id.equals(other.id))
            return false;
        if (day == null) {
            return other.day == null;
        }else if (!day.equals(other.day))
            return false;
        if (price == null) {
            return other.price == null;
        }else return price.equals(other.price);
    }
}



