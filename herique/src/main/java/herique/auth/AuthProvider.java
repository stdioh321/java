/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herique.auth;

import herique.dao.TestesDao;
import herique.entity.Role;
import herique.entity.Testes;
import herique.entity.User;
import herique.entity.UserRole;
import herique.services.RoleService;
import herique.services.TestesService;
import herique.services.UserRoleService;
import herique.services.UserService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

/**
 *
 * @author hdias
 */
@Component
public class AuthProvider implements AuthenticationProvider {
    
    @Autowired
    TestesService service;
    
    @Autowired
    UserService userService;
    
    @Autowired
    UserRoleService userRoleService;
    
    @Autowired
    RoleService roleService;
    
    @Override
    public Authentication authenticate(Authentication a) throws AuthenticationException {
        String username = a.getName();
        String password = a.getCredentials().toString();
        List<User> lstUser = userService.getService().findByUser(username);
        
        System.out.println(username + " - " + password);
        
        if (lstUser.isEmpty()) {
            throw new BadCredentialsException("Usuario não encontrado.");
        } else if (!password.equals(lstUser.get(0).getPass())) {
            throw new BadCredentialsException("Senha Incorreta.");
            
        }
        List lR = new ArrayList();
        Collection<? extends GrantedAuthority> authorities = null;
        for (UserRole ur : userRoleService.getService().findByUserId(lstUser.get(0).getId())) {
            lR.add(ur.getIdRole());
        }
        authorities = lR;

//        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//        authorities.add(new GrantedAuthorityImpl(usuario.getPermissao()));
        return new UsernamePasswordAuthenticationToken(username, password, authorities);
    }
    
    @Override
    public boolean supports(Class<?> type) {
        return true;
    }
    
}
