package asu.ser322.team6.controller;

import asu.ser322.team6.entity.Album;
import asu.ser322.team6.service.AlbumService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class AlbumController {
    private  final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/api/album")
    public ResponseEntity<Album> getAlbumResponse(@RequestBody String name){
        Album album = albumService.findByAlbumName(name);
        return ResponseEntity.ok().body(album);
    }
    @PostMapping("/api/album")
    public ResponseEntity<Void> createAlbumResponse(@RequestBody Map<String, String> albumValues){
        albumService.createAlbum(albumValues);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/api/album/{id}")
    public ResponseEntity<Void> updateAlbumResponse(@PathVariable Long id, @RequestBody Map<String, String> albumValues){
        albumService.updateAlbum(id, albumValues);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/api/album/{id}")
    public ResponseEntity<Void> deleteAlbumResponse(@PathVariable Long id){
        albumService.deleteAlbum(id);
        return ResponseEntity.ok().build();
    }
}
