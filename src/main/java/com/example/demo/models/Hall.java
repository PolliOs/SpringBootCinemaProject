package com.example.demo.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Set;


/**
 * Model represents the database table
 */
@Entity
@Table(name = "halls")
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    @NotNull
    private String hallTitle;


    @Column(name = "seats")
    @NotNull
    private Integer seats;

    @OneToMany(mappedBy="hall")
    private Set<Session> sessions;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the hallTitle
     */
    public String getHallTitle() {
        return hallTitle;
    }

    /**
     * @param hallTitle
     *            the hallTitle to set
     */
    public void setHallTitle(String hallTitle) {
        this.hallTitle = hallTitle;
    }

    /**
     * @return the seats
     */
    public Integer getSeats() {
        return seats;
    }

    /**
     * @param seats
     *            the seats to set
     */
    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((seats == null) ? 0 : seats.hashCode());
        result = prime * result + ((hallTitle == null) ? 0 : hallTitle.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        Hall other = (Hall) obj;
        if (hallTitle == null) {
            if (other.hallTitle != null)
                return false;
        } else if (!hallTitle.equals(other.hallTitle))
            return false;
        if (id == null) {
            return other.id == null;
        } else if (!id.equals(other.id))
        if (seats == null) {
            return other.seats == null;
        } else return seats.equals(other.seats);
        return true;
    }

}