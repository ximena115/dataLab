package com.sena.LabData.authService;

import com.sena.LabData.entity.UsuarioLab;
import com.sena.LabData.repository.UsuarioLabRepository;
import com.sena.LabData.util.CustomPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioLabRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UsuarioLab> user= userRepo.findByUsername(username);

        return user.orElseThrow(()-> new UsernameNotFoundException("Credenciales invalidas")) ;
    }
}
