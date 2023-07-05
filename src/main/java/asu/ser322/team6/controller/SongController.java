package asu.ser322.team6.controller;

import asu.ser322.team6.entity.Song;
import asu.ser322.team6.service.SongService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@CrossOrigin
@RestController
public class SongController {
    private  final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }
    @GetMapping("/api/songs")
    public ResponseEntity<Set<Song>> songResponse(){
        Set<Song> song = songService.getSongs();
        return ResponseEntity.ok().body(song);
    }

    @GetMapping("/api/song")
    public ResponseEntity<Song> songResponse(@RequestParam(name="name") String title){
        Song song = songService.getSongByTitle(title);
        return ResponseEntity.ok().body(song);
    }

    @GetMapping("/api/song/{id}")
    public ResponseEntity<Song> songResponse(@PathVariable Long id){
        Song song = songService.getSong(id);
        return ResponseEntity.ok().body(song);
    }

    @PostMapping("/api/song")
    public ResponseEntity<String> createSongResponse(@RequestBody Map<String, String> songValues){
        songService.createSong(songValues);
        return ResponseEntity.ok().body("Song created");
    }

    @PatchMapping("/api/song/{id}")
    public ResponseEntity<String> updateUserResponse(@PathVariable Long id, @RequestBody Map<String, String> songValues){
        songService.updateSong(id, songValues);
        String statusResponse = String.format("Song: %d updated", id);
        return ResponseEntity.ok().body(statusResponse);
    }

    @DeleteMapping("/api/song/{id}")
    public ResponseEntity<String> deleteArtistResponse(@PathVariable Long id){
        songService.deleteSong(id);
        String statusResponse = String.format("Song: %d deleted", id);
        return ResponseEntity.ok().body(statusResponse);
    }
}
