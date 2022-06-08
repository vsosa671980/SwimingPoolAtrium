package com.piscina.atrium.dao.services;

import com.piscina.atrium.dao.UsersDao;
import com.piscina.atrium.dao.UsersSecurityDao;
import com.piscina.atrium.models.Roles;
import com.piscina.atrium.models.Users;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service("userDetailsService")//For Spring security recognize
//Implements for use spring security
public class UsersDetailsImpl implements UserDetailsService {
     
	@Autowired
     private UsersSecurityDao dao;
     
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
          Users user = dao.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No existe usuario"));

       
        var roles = new ArrayList<GrantedAuthority>();

        for (Roles rol : user.getRoles()) {
            roles.add(new SimpleGrantedAuthority(rol.getNameRole()));
        }
        
        UserDetails userDetail =  new User(user.getUsername(), user.getPassword(), roles);

        //Import object from Spring security and create a new object
        return userDetail;

    }
}

