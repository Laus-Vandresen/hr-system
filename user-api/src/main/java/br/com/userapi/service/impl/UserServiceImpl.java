package br.com.userapi.service.impl;

import br.com.userapi.domain.User;
import br.com.userapi.repository.UserRepository;
import br.com.userapi.service.UserService;
import br.com.userapi.service.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Environment env;

    @Override
    public User findById(Long id) {
        log.info("USERL_SERVICE ::: Get request on " + env.getProperty("server.port") + " port");
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("User not found"));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
