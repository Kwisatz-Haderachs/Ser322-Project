package asu.ser322.team6.persistence;

import asu.ser322.team6.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    Playlist findByPlaylistId(Long id);

    @Override
    <S extends Playlist> S save(S entity);

    @Override
    void deleteById(Long playlistId);
}
