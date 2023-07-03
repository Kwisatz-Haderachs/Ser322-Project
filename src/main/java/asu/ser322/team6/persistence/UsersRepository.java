package asu.ser322.team6.persistence;
import asu.ser322.team6.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository  extends JpaRepository<User, String> {
    User getByAsurite(String asurite);

    @Override
    <S extends User> S save(S entity);

    @Override
    void deleteById(String asurite);
}
