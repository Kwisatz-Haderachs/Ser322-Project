package asu.ser322.team6.service;

import asu.ser322.team6.entity.Artist;
import asu.ser322.team6.persistence.AlbumRepository;
import asu.ser322.team6.persistence.ArtistRepository;
import org.springframework.stereotype.Component;

@Component
public class ArtistService {
    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;

        if (ServiceManager.artistRepository == null)
            ServiceManager.artistRepository = this.artistRepository;
    }

    public Artist getArtist(String name){
        return artistRepository.findByArtistName(name);
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
