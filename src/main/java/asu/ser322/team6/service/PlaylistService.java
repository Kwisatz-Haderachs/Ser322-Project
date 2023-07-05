package asu.ser322.team6.service;

import asu.ser322.team6.entity.Playlist;
import asu.ser322.team6.entity.Song;
import asu.ser322.team6.persistence.PlaylistRepository;
import asu.ser322.team6.persistence.SongRepository;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PlaylistService {
    private final PlaylistRepository playlistRepository;
    private final SongRepository songRepository;


    public PlaylistService(PlaylistRepository playlistRepository, SongRepository songRepository) {
        this.playlistRepository = playlistRepository;
        this.songRepository = songRepository;
    }

    public Set<Playlist> getPlaylists(){
        return new HashSet<>(playlistRepository.findAll());
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

    public void updatePlaylistSongs(Long id, Long songId){
        Playlist playlist = playlistRepository.findByPlaylistId(id);
        Song song = songRepository.getReferenceById(songId);
        playlist.getPlaylistSongs().add(song);
        playlistRepository.save(playlist);
    }
    public void deletePlaylist(Long id){
        playlistRepository.deleteById(id);
    }
}
