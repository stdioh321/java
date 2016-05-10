/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herique;

import herique.dao.TestesDao;
import herique.entity.Testes;
import herique.services.TestesService;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 *
 * @author hdias
 */
@Component
public class AuthProvider implements AuthenticationProvider {
    
    @Autowired
    TestesService service;
    
    @Override
    public Authentication authenticate(Authentication a) throws AuthenticationException {
        String username = a.getName();
        String password = a.getCredentials().toString();
        String principal = a.getPrincipal().toString();
        Testes t = service.getService().findTesteByUser(username);
        System.out.println(username + " - " + password);
        System.out.println(principal);
        if (t == null) {
            throw new BadCredentialsException("Usuario não encontrado.");
        } else if (!password.equals(t.getEmail())) {
            throw new BadCredentialsException("Senha Incorreta.");
            
        }
        System.out.println("Passei");
        return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
    }
    
    @Override
    public boolean supports(Class<?> type) {
        return true;
    }
    
}
