package asu.ser322.team6.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Genre {
    @Id
    private Long genreId;
    private String genre;

    public Genre() {
    }

    public Genre(Long genreId, String genre) {
        this.genreId = genreId;
        this.genre = genre;
    }

    public Long getGenreId() {
        return genreId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
