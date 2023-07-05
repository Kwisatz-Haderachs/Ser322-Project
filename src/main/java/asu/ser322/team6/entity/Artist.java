package asu.ser322.team6.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Artist(Long artistId, String artistName) {
        this.artistId = artistId;
        this.artistName = artistName;
        this.discography = new HashSet<>();
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
