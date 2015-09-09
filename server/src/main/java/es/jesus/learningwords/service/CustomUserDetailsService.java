package es.jesus.learningwords.service;

import es.jesus.learningwords.repository.LanguageRepository;
import es.jesus.learningwords.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by jesus on 24/07/15.
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = userRepository.findByName(username);
        if (user == null) {
            logger.error("User not found: '{}'", username);
            throw new UsernameNotFoundException(username + " not found");
        }
        logger.info("User found: '{}'", username);
        return user;
    }
}
