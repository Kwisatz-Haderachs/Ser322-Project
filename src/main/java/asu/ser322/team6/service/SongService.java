package asu.ser322.team6.service;

import asu.ser322.team6.entity.Genre;
import asu.ser322.team6.entity.Song;
import asu.ser322.team6.persistence.AlbumRepository;
import asu.ser322.team6.persistence.PlaylistRepository;
import asu.ser322.team6.persistence.SongRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class SongService  {

    private final SongRepository songRepository;
    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;

        if (ServiceManager.songRepository == null)
            ServiceManager.songRepository = this.songRepository;
    }

    /**
     *  SQL Queries should do the following
     *
     *
     *  1) Search by title ✅
     *  2) Search by genre ✅
     *  3) Search by artist ✅
     *  4) Search by album ✅
     *
     */

    //region QUERIES
    public Song getSong(String title){
        return songRepository.findByTitle(title);
    }

    public List<Song> findSongsById(Long id) {
        return this.songRepository.findSongByGenreGenreId(id);
    }

    public List<Song> findSongsByGenreType(Genre genre) {
        return this.songRepository.findSongByGenre(genre);
    }

    public List<Song> findSongsByArtist(Long id) {
        return ServiceManager.artistRepository.findByArtistId(id).getDiscography().stream().toList();
    }
    public List<Song> findSongsByArtist(String name) {
        return ServiceManager.artistRepository.findByArtistName(name).getDiscography().stream().toList();
    }

    public List<Song> findSongsByAlbum(String name) {
        return ServiceManager.albumRepository.findByAlbumName(name).getAlbumSongs().stream().toList();
    }
    public List<Song> findSongsByAlbum(Long id) {
        return ServiceManager.albumRepository.findByAlbumId(id).getAlbumSongs().stream().toList();
    }
    //endregion

    //region CREATE -- UPDATE -- DELETE
    public void createSong(Map<String, String> values){
        Song song = new Song(
                values.get("title"),
                Integer.parseInt(values.get("yearOfRelease")),
                values.get("duration")
        );
        songRepository.save(song);
    }
    public void updateSong(Long id, Map<String, String> values){
        Song song = songRepository.getReferenceById(id);
        for (String s: values.keySet()) {
            switch (s) {
                case "title": song.setTitle(values.get(s));
                case "yearOfRelease": song.setYearOfRelease(Integer.parseInt(values.get(s)));
                case "duration": song.setDuration(values.get(s));
            }
        }
        songRepository.save(song);
    }
    public void deleteSong(Long id){
        songRepository.deleteById(id);
    }
    //endregion

}
