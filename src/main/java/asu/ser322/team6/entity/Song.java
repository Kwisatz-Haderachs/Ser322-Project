package asu.ser322.team6.entity;

import javax.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue
    private Long songId;

    private String title;
    private int yearOfRelease;
    private String duration;

    @JoinTable(
            name = "song_genre",
            joinColumns = @JoinColumn(
                    name = "song_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "genre_id"
            )
    )
    @ManyToOne
    private Genre genre;

    public Song(String title, int yearOfRelease, String duration) {
        this.title = title;
        this.yearOfRelease = yearOfRelease;
        this.duration = duration;
    }
    public Song(){}

    public Long getSongId() {
        return songId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
