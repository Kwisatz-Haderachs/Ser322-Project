package asu.ser322.team6.service;

import asu.ser322.team6.entity.Artist;
import asu.ser322.team6.entity.Song;
import asu.ser322.team6.persistence.ArtistRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArtistService {
    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public List<Artist> getAllArtists(){
        return artistRepository.findAll();
    }
    public Artist getArtist(Long id){
        return artistRepository.getReferenceById(id);
    }

    public List<Song> findSongsByArtist(Long id) {
        return artistRepository.findByArtistId(id).getDiscography().stream().toList();
    }
    public List<Song> findSongsByArtist(String name) {
        return artistRepository.findByArtistName(name).getDiscography().stream().toList();
    }
    public void createArtist(String artistName){
        Artist artist = new Artist(artistName);
        artistRepository.save(artist);
    }

    public void updateArtist(Long id, String artistName){
        Artist artist = artistRepository.findByArtistId(id);
        artist.setArtistName(artistName);
        artistRepository.save(artist);
    }
    public void deleteArtist(Long id){
        artistRepository.deleteById(id);
    }
}
