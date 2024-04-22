package org.example.wecommerce.services;

import org.example.wecommerce.exeptions.NotFoundException;
import org.example.wecommerce.models.User;
import org.example.wecommerce.repositories.UserRepository;
import org.example.wecommerce.requests.UserDeleteRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User add(User user) {
        return userRepository.save(new User(user.getUserName(),
                user.getPassword(), user.getEMail()));
    }
    
    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    public User getById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("user couldn't be found by following id: " + id));
    }

    public void deleteById(int id) {
        this.userRepository.deleteById(id);
    }

    public List<User> getUserViewDto() {
        return this.userRepository.findAll();
    }

    public void delete(UserDeleteRequest userDeleteRequest) {
        Integer id = userDeleteRequest.getId();
        userRepository.deleteById(id);
    }

    public User findByEMail(String eMail) {
        return userRepository.findByEMail(eMail);
    }

    public void updateByUserName(int userId, String userName) {
        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()) {
            user.get().setUserName(userName);
            userRepository.save(user.get());
        }
    }
}
