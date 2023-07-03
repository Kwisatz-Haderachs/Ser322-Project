package asu.ser322.team6.persistence;

import asu.ser322.team6.entity.Genre;
import asu.ser322.team6.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    @Override
    <S extends Genre> S save(S entity);
    @Override
    void deleteById(Long genreId);
}
