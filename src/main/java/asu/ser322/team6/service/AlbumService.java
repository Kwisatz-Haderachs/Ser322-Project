package asu.ser322.team6.service;

import asu.ser322.team6.entity.Album;
import asu.ser322.team6.entity.Artist;
import asu.ser322.team6.entity.Genre;
import asu.ser322.team6.persistence.AlbumRepository;

import org.springframework.stereotype.Component;

import asu.ser322.team6.service.GenreService;

import java.sql.Time;
import java.util.List;
import java.util.Map;

@Component
public class AlbumService {

    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;

        if (ServiceManager.albumRepository == null)
            ServiceManager.albumRepository = this.albumRepository;
    }

    /**
     *  SQL Queries should do the following
     *
     *
     *  1) Search by name ✅
     *  2) Search by artist ✅
     *  3) Search by genre ✅
     *
     */

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

    /**
     * Seeks albums by genre id
     * @param id genre id
     * @return a list of albums
     */
    public List<Album> findAlbumsByGenre(Long id) {
        Genre genre = GenreService.findGenre(id);
        var albums = albumRepository.findAll();
        albums = albums.stream().filter( a -> a.hasSongs()).toList();
        albums = albums.stream().filter( a -> a.getAlbumSongs().stream().anyMatch(s -> s.getGenre().equals(genre))).toList();
        return albums;
    }

    /**
     * Seeks albums by genre name
     * @param name genre name
     * @return a list of albums
     */
    public List<Album> findAlbumsByGenre(String name) {
        Genre genre = GenreService.findGenre(name);
        var albums = albumRepository.findAll();
        albums = albums.stream().filter( a -> a.hasSongs()).toList();
        albums = albums.stream().filter( a -> a.getAlbumSongs().stream().anyMatch(s -> s.getGenre().equals(genre))).toList();
        return albums;
    }

    /**
     * seeks albums by artist id
     * @param id artist id
     * @return a list of albums
     */
    List<Album> findAlbumsByArtistId(Long id) {
        return this.albumRepository.findAlbumsByArtistId(id);
    }

    /**
     * seeks albums by artist name
     * @param name artist name
     * @return a list of albums
     */
    List<Album> findAlbumsByArtistName(String name) {
        Artist artist = ServiceManager.artistRepository.findByArtistName(name);
        return this.findAlbumsByArtistId(artist.getArtistId());
    }
    
    //region CREATE UPDATE DELETE
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
                case "albumName": album.setAlbumName(values.get(s));
                case "duration": album.setDuration(Time.valueOf(values.get(s)));
                case "artistId": album.setArtistId(Long.valueOf(values.get(s)));
            }
        }
        albumRepository.save(album);
    }
    public void deleteAlbum(Long id){
        albumRepository.deleteById(id);
    }
    //endregion
}
