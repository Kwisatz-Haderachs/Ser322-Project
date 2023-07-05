package asu.ser322.team6.controller;

import asu.ser322.team6.entity.Song;
import asu.ser322.team6.service.SongService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class SongController {
    private  final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }
    @GetMapping("/api/songs")
    public ResponseEntity<List<Song>> songResponse(){
        List<Song> song = songService.getSongs();
        return ResponseEntity.ok().body(song);
    }

    @GetMapping("/api/song")
    public ResponseEntity<Song> songResponse(@RequestParam String title){
        Song song = songService.getSongByTitle(title);
        return ResponseEntity.ok().body(song);
    }

    @GetMapping("/api/song/{id}")
    public ResponseEntity<Song> songResponse(@PathVariable Long id){
        Song song = songService.getSong(id);
        return ResponseEntity.ok().body(song);
    }

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
