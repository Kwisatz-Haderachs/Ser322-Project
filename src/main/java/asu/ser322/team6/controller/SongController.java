package asu.ser322.team6.controller;

import asu.ser322.team6.entity.Song;
import asu.ser322.team6.service.SongService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class SongController {
    private  final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    // QUERIES ------------------------------------------------------------------------------

    @GetMapping("/api/song")
    public ResponseEntity<Song> songResponse(@RequestBody String title){
        Song song = songService.getSong(title);
        return ResponseEntity.ok().body(song);
    }

    // CREATE -- UPDATE -- DELETE ------------------------------------------------------------
    @PostMapping("/api/song")
    public ResponseEntity<Void> createSongResponse(@RequestBody Map<String, String> songValues){
        songService.createSong(songValues);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/api/song/{id}")
    public ResponseEntity<Void> updateUserResponse(@PathVariable Long id, @RequestBody Map<String, String> songValues){
        songService.updateSong(id, songValues);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/api/song/{id}")
    public ResponseEntity<Void> deleteArtistResponse(@PathVariable Long id){
        songService.deleteSong(id);
        return ResponseEntity.ok().build();
    }
}
