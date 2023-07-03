package asu.ser322.team6.service;

import asu.ser322.team6.entity.Song;
import asu.ser322.team6.persistence.SongRepository;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SongService {

    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public Song getSong(String title){
        return songRepository.findByTitle(title);
    }

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
                case "title" -> song.setTitle(values.get(s));
                case "yearOfRelease" -> song.setYearOfRelease(Integer.parseInt(values.get(s)));
                case "duration" -> song.setDuration(values.get(s));
            }
        }
        songRepository.save(song);
    }
    public void deleteSong(Long id){
        songRepository.deleteById(id);
    }
}
