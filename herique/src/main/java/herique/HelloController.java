/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herique;

import herique.entity.Testes;
import herique.services.TestesService;
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
        return ResponseEntity.ok(s.getService().findAll());
    }

    @RequestMapping(value = {"/test2"})
    public ResponseEntity test2Get(@RequestBody(required = true) Testes t) {
        Testes tmp = s.getService().findTesteByUser(t.getName());

        return ResponseEntity.ok(tmp);

    }

    @RequestMapping(value = {"/hello"})
    public ModelAndView hello(ModelMap mm) {
        mm.addAttribute("testes", (String) SecurityContextHolder.getContext().getAuthentication().getCredentials());
        return new ModelAndView("hello");
    }
}
