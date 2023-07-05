package asu.ser322.team6.persistence;

import asu.ser322.team6.entity.Playlist;
import asu.ser322.team6.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    Playlist findByPlaylistId(Long id);

    @Override
    <S extends Playlist> S save(S entity);

    Set<Playlist> findAllByPlaylistSongsContains(Song song);

    @Override
    void deleteById(Long playlistId);
}
