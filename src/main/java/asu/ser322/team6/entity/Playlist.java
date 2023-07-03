package asu.ser322.team6.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Playlist {
    @Id
    @GeneratedValue
    private Long playlistId;
    private Date creationDate;
    private String title;
    private String asurite;
    @JoinTable(
            name = "playlist_songs",
            joinColumns = @JoinColumn(
                    name = "playlist_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "song_id"
            )
    )
    @OneToMany
    private Set<Song> playlistSongs;

    public Playlist() {
    }

    public Playlist(Date creationDate, String title, String userId) {
        this.creationDate = creationDate;
        this.title = title;
        this.asurite = userId;
    }

    public Long getPlaylistId() {
        return playlistId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserId() {
        return asurite;
    }

    public void setUserId(String userId) {
        this.asurite = userId;
    }

    public Set<Song> getPlaylistSongs() {
        return playlistSongs;
    }
}


