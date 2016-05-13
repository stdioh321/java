/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herique.controller;

import herique.entity.Expression;
import herique.entity.Role;
import herique.entity.Testes;
import herique.services.ExpressionService;
import herique.services.RoleService;
import herique.services.TestesService;
import herique.services.UserRoleService;
import herique.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author hdias
 */
@RestController
public class HelloController {

    @Autowired
    TestesService s;

    @Autowired
    UserService uService;

    @Autowired
    RoleService rService;

    @Autowired
    UserRoleService urService;

    @Autowired
    ExpressionService eService;

    @RequestMapping(value = {"", "/home"})
    public ModelAndView index() {
        return new ModelAndView("home");
    }

    @RequestMapping(value = {"/login"})
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @RequestMapping(value = {"/test"})
    public ResponseEntity testGet() {
        List<Expression> lst = eService.getService().findAll();
        for (Expression e : lst) {
            System.out.println(e.getIdRole().getName());
        }
        return ResponseEntity.ok(eService.getService().findAll());
    }

    @RequestMapping(value = {"/test2"})
    public ResponseEntity test2Get() {
        
        return ResponseEntity.ok(urService.getService().findByUserId(2));

    }

    @RequestMapping(value = {"/test3"})
    public ResponseEntity test3Get() {
        return ResponseEntity.ok(SecurityContextHolder.getContext());

    }

    @RequestMapping(value = {"/hello"})
    public ResponseEntity hello(ModelMap mm) {

        return ResponseEntity.ok("Hello");
    }

    @RequestMapping(value = {"/403"})
    public ResponseEntity denied() {
        return ResponseEntity.ok("403");
    }



}
