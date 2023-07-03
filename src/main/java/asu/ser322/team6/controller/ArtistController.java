package asu.ser322.team6.controller;

import asu.ser322.team6.entity.Artist;
import asu.ser322.team6.service.ArtistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ArtistController {
    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/api/artist")
    public ResponseEntity<Artist> albumResponse(@RequestBody String name){
        Artist artist = artistService.getArtist(name);
        return ResponseEntity.ok().body(artist);
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
