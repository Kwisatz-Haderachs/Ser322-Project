package asu.ser322.team6.entity;

import asu.ser322.team6.service.GenreService;

import javax.persistence.*;
import java.sql.Time;
import java.util.Set;

@Entity
public class Album {
    @Id
    @GeneratedValue
    private Long albumId;

    private String albumName;
    private Time duration;
    private Long artistId;

    @JoinTable(
            name = "album_song",
            joinColumns = @JoinColumn(
                    name = "album_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "song_id"
            )
    )
    @OneToMany
    private Set<Song> albumSongs;

    public Album() {
    }

    public Album(String albumName, Time duration, Long artistId) {
        this.albumName = albumName;
        this.duration = duration;
        this.artistId = artistId;
    }

    public Set<Song> getAlbumSongs() {
        return albumSongs;
    }

    public void setAlbumSongs(Set<Song> albumSongs) {
        this.albumSongs = albumSongs;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public Long getArtistId() {
        return artistId;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }

    public boolean hasSongs() {
        return this.albumSongs.size() > 0;
    }

    public Genre getAlbumGenre() {
        return GenreService.findGenreByAlbum(this);
    }
}
