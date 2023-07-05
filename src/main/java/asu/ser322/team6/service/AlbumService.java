package asu.ser322.team6.service;

import asu.ser322.team6.entity.Album;
import asu.ser322.team6.entity.Genre;
import asu.ser322.team6.entity.Song;
import asu.ser322.team6.persistence.AlbumRepository;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class AlbumService {

    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public Set<Album> getAllAlbums(){
        return new HashSet<>(albumRepository.findAll());
    }

    /**
     * Retrieves an album of the name
     * @param name album name
     * @return a single album
     */
    public Album findByAlbumName(String name){
        return albumRepository.findByAlbumName(name);
    }
    /**
     * Retrieves an album of the id
     * @param id album id
     * @return a single album
     */
    public Album findByAlbumId(Long id) { return albumRepository.findByAlbumId(id); }

    public List<Song> findSongsByAlbum(String name) {
        return albumRepository.findByAlbumName(name).getAlbumSongs().stream().toList();
    }

    public List<Song> findSongsByAlbum(Long id) {
        return albumRepository.findByAlbumId(id).getAlbumSongs().stream().toList();
    }
    /**
     * Seeks albums by genre name
     * @param name genre name
     * @return a list of albums
     */
    public Set<Album> findAlbumsByGenre(String name) {
        Genre genre = GenreService.findGenre(name);
        return getAlbumHashSet(genre);
    }
    /**
     * Seeks albums by genre id
     * @param id genre id
     * @return a list of albums
     */
    public Set<Album> findAlbumsByGenre(Long id) {
        Genre genre = GenreService.findGenre(id);
        return getAlbumHashSet(genre);
    }

    private HashSet<Album> getAlbumHashSet(Genre genre) {
        var albums = albumRepository.findAll();
        albums = albums.stream().filter( a -> a.hasSongs()).toList();
        albums = albums.stream().filter( a -> a.getAlbumSongs().stream().anyMatch(s -> s.getGenre().equals(genre))).toList();
        return new HashSet<>(albums);
    }

    public void createAlbum(Map<String, String> values){
        Album album = new Album(
                Long.valueOf(values.get("albumId")),
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
