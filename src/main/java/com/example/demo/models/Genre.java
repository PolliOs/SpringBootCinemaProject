package com.example.demo.models;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    @NotNull
    private String genreTitle;


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
     * @return the genreTitle
     */
    public String getGenreTitle() {
        return genreTitle;
    }

    /**
     * @param genreTitle the genreTitle to set
     */
    public void setGenreTitle(String genreTitle) {
        this.genreTitle = genreTitle;
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
        result = prime * result + ((genreTitle == null) ? 0 : genreTitle.hashCode());
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
        Genre other = (Genre) obj;
        if (genreTitle == null) {
            if (other.genreTitle != null)
                return false;
        } else if (!genreTitle.equals(other.genreTitle))
            return false;
        if (id == null) {
            return other.id == null;
        }else return id.equals(other.id);
    }
}


