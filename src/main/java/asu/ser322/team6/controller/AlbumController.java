package asu.ser322.team6.controller;

import asu.ser322.team6.entity.Album;
import asu.ser322.team6.service.AlbumService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.Map;

@CrossOrigin
@RestController
public class AlbumController {
    private  final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/api/albums")
    public ResponseEntity<Set<Album>> getAlbumsResponse(){
        Set<Album> album = albumService.getAllAlbums();
        return ResponseEntity.ok().body(album);
    }
    @GetMapping("/api/album")
    public ResponseEntity<Album> getAlbumResponse(@RequestParam(name="name") String name){
        Album album = albumService.findByAlbumName(name);
        return ResponseEntity.ok().body(album);
    }

    @GetMapping("/api/album/genre")
    public ResponseEntity<Set<Album>> getAlbumsResponse(@RequestParam(name="genre") String genre){
        var albums = albumService.findAlbumsByGenre(genre);
        return ResponseEntity.of(java.util.Optional.of(albums));
    }

    @PostMapping("/api/album")
    public ResponseEntity<String> createAlbumResponse(@RequestBody Map<String, String> albumValues){
        albumService.createAlbum(albumValues);
        return ResponseEntity.ok().body("Album created");
    }

    @PatchMapping("/api/album/{id}")
    public ResponseEntity<String> updateAlbumResponse(@PathVariable Long id, @RequestBody Map<String, String> albumValues){
        albumService.updateAlbum(id, albumValues);
        String statusResponse = String.format("Album: %d updated", id);
        return ResponseEntity.ok().body(statusResponse);
    }

    @DeleteMapping("/api/album/{id}")
    public ResponseEntity<String> deleteAlbumResponse(@PathVariable Long id){
        albumService.deleteAlbum(id);
        String statusResponse = String.format("Album: %d delete", id);
        return ResponseEntity.ok().body(statusResponse);
    }
}
