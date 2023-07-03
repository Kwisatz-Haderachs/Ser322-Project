package asu.ser322.team6.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Artist {
    @Id
    @GeneratedValue
    private Long artistId;
    private String artistName;
    @JoinTable(
            name = "artist_song",
            joinColumns = @JoinColumn(
                    name = "artist_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "song_id"
            )
    )
    @OneToMany
    private Set<Song> discography;

    public Artist() {
    }

    public Artist(String name) {
        this.artistName = name;
    }

    public Long getArtistId() {
        return artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public Set<Song> getDiscography() {
        return discography;
    }

    public void setDiscography(Set<Song> discography) {
        this.discography = discography;
    }
}
