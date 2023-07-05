package asu.ser322.team6.service;

import asu.ser322.team6.entity.Playlist;
import asu.ser322.team6.persistence.PlaylistRepository;
import org.springframework.stereotype.Component;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TooManyListenersException;

@Component
public class PlaylistService {
    private final PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public List<Playlist> getPlaylists(){
        return playlistRepository.findAll();
    }

    public Playlist getPlaylist(Long id){
        return playlistRepository.findByPlaylistId(id);
    }

    public void createPlaylist(Map<String, String> values){
        Playlist playlist = new Playlist(
                new Date(),
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
