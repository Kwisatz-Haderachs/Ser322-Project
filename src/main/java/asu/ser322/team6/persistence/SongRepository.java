package asu.ser322.team6.persistence;

import asu.ser322.team6.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long>
{
    Song findByTitle(String title);

    // List<Song> findAllByTitleLikeIgnoreCase(String title);

    @Override
    <S extends Song> S save(S entity);

    void deleteById(Long songId);

}
