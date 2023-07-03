package asu.ser322.team6.persistence;

import asu.ser322.team6.entity.Artist;
import asu.ser322.team6.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    Artist findByArtistId(Long id);
    Artist findByArtistName(String name);
    @Override
    <S extends Artist> S save(S entity);

    @Override
    void deleteById(Long artistId);
}
