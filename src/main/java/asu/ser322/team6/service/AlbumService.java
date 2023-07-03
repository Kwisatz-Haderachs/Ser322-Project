package asu.ser322.team6.service;

import asu.ser322.team6.entity.Album;
import asu.ser322.team6.persistence.AlbumRepository;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.Map;

@Component
public class AlbumService {

    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public Album findByAlbumName(String name){
        return albumRepository.findByAlbumName(name);
    }

    public void createAlbum(Map<String, String> values){
        Album album = new Album(
                values.get("albumName"),
                Time.valueOf(values.get("duration")),
                Long.valueOf("artistId")
                );
        albumRepository.save(album);
    }

    public void updateAlbum(Long id, Map<String, String> values){
        Album album = albumRepository.findByAlbumId(id);
        for (String s: values.keySet()) {
            switch (s) {
                case "albumName" -> album.setAlbumName(values.get(s));
                case "duration" -> album.setDuration(Time.valueOf(values.get(s)));
                case "artistId" -> album.setArtistId(Long.valueOf(values.get(s)));
            }
        }
        albumRepository.save(album);
    }
    public void deleteAlbum(Long id){
        albumRepository.deleteById(id);
    }
}
