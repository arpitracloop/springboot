package com.springboot.crud.service;

import com.springboot.crud.entity.JwtRequest;
import com.springboot.crud.entity.JwtResponse;
import com.springboot.crud.entity.Student;
import com.springboot.crud.repository.StudentRepository;
import com.springboot.crud.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JwtService implements UserDetailsService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception{
        String username = jwtRequest.getUserName();
        String userPassword = jwtRequest.getUserPassword();
        authenticate(username, userPassword);
        final UserDetails userDetails = loadUserByUsername(username);
        String newGeneratedToken =  jwtUtil.generateJwtToken(userDetails);
        Student student = (Student) studentRepository.findByName(username);
        return new JwtResponse(student, newGeneratedToken);

    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = (User) studentRepository.findByName(username);
        if (user != null){
            return new User(
                    user.getUserName(),
                    user.getUserPassword()


            );
        }
        else {
            throw new UsernameNotFoundException("Username is not Valid");
        }
    }
//
//    private Set getAuthorities(Student student){
//        Set authorities = new HashSet();
//        student.getRoles().forEach(role -> {
//            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
//        });
//        return authorities;
//    }

    private void authenticate(String username, String userPassword) throws Exception{
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, userPassword));
        }
        catch(DisabledException e){
            throw new Exception("User is disabled");
        }
        catch (BadCredentialsException e){
            throw new Exception("Bad Credentials from user");
        }

    }
}
