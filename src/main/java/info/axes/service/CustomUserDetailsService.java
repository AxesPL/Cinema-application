package info.axes.service;

import info.axes.model.entity.User;
import info.axes.model.entity.UserAuthority;
import info.axes.repository.UserAuthorityRepository;
import info.axes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Primary
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserAuthorityRepository userAuthorityRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findFirstByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("User not found");
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPasswordHash(),
                convertAuthorities(userAuthorityRepository.findAllByUser_Id(user.getId())));
    }

    private Set<GrantedAuthority> convertAuthorities(List<UserAuthority> userAuthorities) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (UserAuthority ua : userAuthorities) {
            authorities.add(new SimpleGrantedAuthority(ua.getAuthority().getName()));
        }
        return authorities;
    }
}