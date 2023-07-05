package asu.ser322.team6.controller;

import asu.ser322.team6.entity.Playlist;
import asu.ser322.team6.service.PlaylistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class PlaylistController {

    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @GetMapping("/api/playlists")
    public ResponseEntity<List<Playlist>> playlistsResponse(){
        List<Playlist> playlists = playlistService.getPlaylists();
        return ResponseEntity.ok().body(playlists);
    }

    @GetMapping("/api/playlist/{id}")
    public ResponseEntity<Playlist> playlistResponse(@PathVariable Long id){
        Playlist playlist = playlistService.getPlaylist(id);
        return ResponseEntity.ok().body(playlist);
    }

    @PostMapping("/api/playlist")
    public ResponseEntity<Void> createPlaylistResponse(@RequestBody Map<String, String> playlistValues){
        playlistService.createPlaylist(playlistValues);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/api/playlist/{id}")
    public ResponseEntity<Void> updatePlaylistResponse(@PathVariable Long id, @RequestBody String playlistName){
        playlistService.updatePlaylist(id, playlistName);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/api/playlist/{id}")
    public ResponseEntity<Void> deletePlaylistResponse(@PathVariable Long id){
        playlistService.deletePlaylist(id);
        return ResponseEntity.ok().build();
    }
}
