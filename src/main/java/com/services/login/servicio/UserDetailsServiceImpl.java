package com.services.login.servicio;

import java.util.ArrayList;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.services.login.dao.UsuarioRepository;
import com.services.login.modelo.Usuarios;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	 @Autowired
	    private UsuarioRepository userRepository;

	    @Override
	   	    public UserDetails loadUserByUsername(String username) {
	        Usuarios user = userRepository.findOne(username);
	        if (user == null) throw new UsernameNotFoundException(username);

	         List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
	      /*  for (Role role : user.getRoles()){
	            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
	        }
           */
	        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getContrasena(), grantedAuthorities);
	    }

}
