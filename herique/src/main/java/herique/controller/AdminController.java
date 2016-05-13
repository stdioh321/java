/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herique.controller;

import herique.entity.Testes;
import herique.services.TestesService;
import java.util.List;
import javax.servlet.ServletRequest;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author hdias
 */
@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    TestesService service;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(service.getService().findAll());
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity postOne(@PathParam("name") String name) {
        return ResponseEntity.ok(name);
    }

    @RequestMapping(value = "hello")
    public ModelAndView hello() {
        return new ModelAndView("admin/hello");
    }

}
