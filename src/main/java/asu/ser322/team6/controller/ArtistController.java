package asu.ser322.team6.controller;

import asu.ser322.team6.entity.Artist;
import asu.ser322.team6.entity.Song;
import asu.ser322.team6.service.ArtistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@CrossOrigin
@RestController
public class ArtistController {
    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/api/artists")
    public ResponseEntity<Set<Artist>> artistResponse(){
        Set<Artist> artists = artistService.getAllArtists();
        return ResponseEntity.ok().body(artists);
    }

    @GetMapping("/api/artist/songs")
    public ResponseEntity<Set<Song>> artistSongResponse(@RequestParam(name="name") String name){
        Set<Song> songsByArtist = artistService.findSongsByArtist(name);
        return ResponseEntity.ok().body(songsByArtist);
    }
    @GetMapping("/api/artist/{id}")
    public ResponseEntity<Artist> artistResponse(@PathVariable Long id){
        Artist artist = artistService.getArtist(id);
        return ResponseEntity.ok().body(artist);
    }

    @GetMapping("/api/artist/songs/{id}")
    public ResponseEntity<Set<Song>> artistSongResponse(@PathVariable Long id){
        Set<Song> songByArtist = artistService.findSongsByArtist(id);
        return ResponseEntity.ok().body(songByArtist);
    }

    @PostMapping("/api/artist")
    public ResponseEntity<String> createArtistResponse(@RequestBody Map<String, String> artistValues){
        artistService.createArtist(artistValues);
        return ResponseEntity.ok().body("Artist created");
    }

    @PatchMapping("/api/artist/{id}")
    public ResponseEntity<String> updateArtistResponse(@PathVariable Long id, @RequestBody String artistName){
        artistService.updateArtist(id, artistName);
        String statusResponse = String.format("Artis: %d updated", id);
        return ResponseEntity.ok().body(statusResponse);
    }


    @DeleteMapping("/api/artist/{id}")
    public ResponseEntity<String> deleteArtistResponse(@PathVariable Long id){
        artistService.deleteArtist(id);
        String statusResponse = String.format("Artist: %d deleted", id);
        return ResponseEntity.ok().body(statusResponse);
    }
}
