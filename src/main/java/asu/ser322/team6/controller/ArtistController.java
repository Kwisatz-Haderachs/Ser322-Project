package asu.ser322.team6.controller;

import asu.ser322.team6.entity.Artist;
import asu.ser322.team6.entity.Song;
import asu.ser322.team6.service.ArtistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ArtistController {
    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/api/artists")
    public ResponseEntity<List<Artist>> artistResponse(){
        List<Artist> artists = artistService.getAllArtists();
        return ResponseEntity.ok().body(artists);
    }

    @GetMapping("/api/artist/songs")
    public ResponseEntity<List<Song>> artistSongResponse(@RequestParam String name){
        List<Song> songsByArtist = artistService.findSongsByArtist(name);
        return ResponseEntity.ok().body(songsByArtist);
    }
    @GetMapping("/api/artist/{id}")
    public ResponseEntity<Artist> artistResponse(@PathVariable Long id){
        Artist artist = artistService.getArtist(id);
        return ResponseEntity.ok().body(artist);
    }

    @GetMapping("/api/artist/songs/{id}")
    public ResponseEntity<List<Song>> artistSongResponse(@PathVariable Long id){
        List<Song> songByArtist = artistService.findSongsByArtist(id);
        return ResponseEntity.ok().body(songByArtist);
    }

    @PostMapping("/api/artist")
    public ResponseEntity<Void> createArtistResponse(@RequestBody String artistValues){
        artistService.createArtist(artistValues);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/api/artist/{id}")
    public ResponseEntity<Void> updateArtistResponse(@PathVariable Long id, @RequestBody String artistName){
        artistService.updateArtist(id, artistName);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/api/artist/{id}")
    public ResponseEntity<Void> deleteArtistResponse(@PathVariable Long id){
        artistService.deleteArtist(id);
        return ResponseEntity.ok().build();
    }
}
