package asu.ser322.team6.service;

import asu.ser322.team6.entity.Artist;
import asu.ser322.team6.entity.Song;
import asu.ser322.team6.persistence.ArtistRepository;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
public class ArtistService {
    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public Set<Artist> getAllArtists(){
        return new HashSet<>(artistRepository.findAll());
    }
    public Artist getArtist(Long id){
        return artistRepository.getReferenceById(id);
    }

    public Set<Song> findSongsByArtist(Long id) {
        return new HashSet<>(artistRepository.findByArtistId(id).getDiscography());
    }
    public Set<Song> findSongsByArtist(String name) {
        return new HashSet<>(artistRepository.findByArtistName(name).getDiscography());
    }
    public void createArtist(Map<String, String> values){
        Artist artist = new Artist(
                Long.parseLong(values.get("artistId")),
                values.get("artistName"));
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
