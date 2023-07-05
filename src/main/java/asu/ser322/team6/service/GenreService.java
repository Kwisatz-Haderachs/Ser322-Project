package asu.ser322.team6.service;

import asu.ser322.team6.entity.Album;
import asu.ser322.team6.entity.Genre;
import asu.ser322.team6.persistence.GenreRepository;
import org.springframework.stereotype.Component;

@Component
public class GenreService {

    private static GenreRepository genreRepository = null;

    public GenreService(GenreRepository genreRepository) {
        if (GenreService.genreRepository == null)
            GenreService.genreRepository = genreRepository;
    }

    public static Genre findGenre(String genre) {
        return findGenreByName(genre);
    }

    public static Genre findGenre(Long id) {
        return findByGenreId(id);
    }

    private static Genre findByGenreId(Long id) {
        return genreRepository.findByGenreId(id);
    }
    private static Genre findGenreByName(String genre) {
        return genreRepository.findGenreByGenre(genre);
    }

    public static Genre findGenreByAlbum(Album album) {
        return (album.getAlbumSongs().stream().toList().get(0).getGenre());

    }

    private static boolean isSingleGenreAlbum(Album album) {
        return album.getAlbumSongs().stream().distinct().toList().size() == 1;
    }

}
