package asu.ser322.team6.controller;

import asu.ser322.team6.entity.Playlist;
import asu.ser322.team6.service.PlaylistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@CrossOrigin
@RestController
public class PlaylistController {

    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @GetMapping("/api/playlists")
    public ResponseEntity<Set<Playlist>> playlistsResponse(){
        Set<Playlist> playlists = playlistService.getPlaylists();
        return ResponseEntity.ok().body(playlists);
    }

    @GetMapping("/api/playlist/{id}")
    public ResponseEntity<Playlist> playlistResponse(@PathVariable Long id){
        Playlist playlist = playlistService.getPlaylist(id);
        return ResponseEntity.ok().body(playlist);
    }

    @PostMapping("/api/playlist")
    public ResponseEntity<String> createPlaylistResponse(@RequestBody Map<String, String> playlistValues){
        playlistService.createPlaylist(playlistValues);
        String statusResponse = "Playlist created";
        return ResponseEntity.ok().body(statusResponse);
    }

    @PatchMapping("/api/playlist/{id}")
    public ResponseEntity<String> updatePlaylistResponse(@PathVariable Long id, @RequestBody String playlistName){
        playlistService.updatePlaylist(id, playlistName);
        String statusResponse = String.format("Playlist: %d updated", id);
        return ResponseEntity.ok().body(statusResponse);
    }

    @PatchMapping("/api/playlist/{id}/songs/{songId}")
    public ResponseEntity<String> addSongToPlaylistResponse(@PathVariable Long id, @PathVariable Long songId){
        playlistService.updatePlaylistSongs(id, songId);
        String statusResponse = String.format("Song added to playlist: %d", id);
        return ResponseEntity.ok().body(statusResponse);
    }

    @DeleteMapping("/api/playlist/{id}")
    public ResponseEntity<String> deletePlaylistResponse(@PathVariable Long id){
        playlistService.deletePlaylist(id);
        String statusResponse = String.format("Playlist: %d deleted", id);
        return ResponseEntity.ok().body(statusResponse);
    }
}
