package asu.ser322.team6.service;

import asu.ser322.team6.entity.User;
import asu.ser322.team6.persistence.UsersRepository;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
public class UserService {

    private final UsersRepository userRepository;

    public UserService(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(String username){
        return userRepository.getByAsurite(username);
    }

    public void createUser(Map<String, String> values){
        User user = new User(
                values.get("username"),
                values.get("asurite")
        );
        userRepository.save(user);
    }

    public void updateUser(String asurite, String username){
        User user = userRepository.getReferenceById(asurite);
        user.setUsername(username);
        userRepository.save(user);
    }
    public void deleteUser(String asurite){
        userRepository.deleteById(asurite);
    }

    public Set<User> getAllUser() {
        return new HashSet<>(userRepository.findAll());
    }
}
