package asu.ser322.team6.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "users")
public class User {
    private String username;
    @Id
    private String asurite;

    @JoinTable(
            name = "user_playlist",
            joinColumns = @JoinColumn(
                    name = "user_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "playlist_id"
            )
    )
    @OneToMany
    private Collection<Playlist> playlists;

    public User() {}

    public User(String username, String asurite) {
        this.username = username;
        this.asurite = asurite;
        playlists = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAsurite() {
        return asurite;
    }

    public void setAsurite(String asurite) {
        this.asurite = asurite;
    }

    public Collection<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Collection<Playlist> playlists) {
        this.playlists = playlists;
    }
}
