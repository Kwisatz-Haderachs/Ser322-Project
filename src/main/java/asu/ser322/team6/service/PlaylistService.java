package asu.ser322.team6.service;

import asu.ser322.team6.entity.Playlist;
import asu.ser322.team6.persistence.ArtistRepository;
import asu.ser322.team6.persistence.PlaylistRepository;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Map;

@Component
public class PlaylistService {
    private final PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;

        if (ServiceManager.playlistRepository == null)
            ServiceManager.playlistRepository = this.playlistRepository;
    }

    public Playlist getPlaylist(Long id){
        return playlistRepository.findByPlaylistId(id);
    }

    public void createPlaylist(Map<String, String> values){
        Playlist playlist = new Playlist(
                Date.valueOf(values.get("creationDate")),
                values.get("title"),
                values.get("asurite")
        );
        playlistRepository.save(playlist);
    }

    public void updatePlaylist(Long id, String title){
        Playlist playlist = playlistRepository.findByPlaylistId(id);
        playlist.setTitle(title);
        playlistRepository.save(playlist);
    }
    public void deletePlaylist(Long id){
        playlistRepository.deleteById(id);
    }
}
