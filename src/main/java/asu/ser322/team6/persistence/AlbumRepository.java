package asu.ser322.team6.persistence;

import asu.ser322.team6.entity.Album;
import asu.ser322.team6.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    Album findByAlbumId(Long id);
    Album findByAlbumName(String name);
    @Override
    <S extends Album> S save(S entity);

    @Override
    void deleteById(Long albumId);
}
