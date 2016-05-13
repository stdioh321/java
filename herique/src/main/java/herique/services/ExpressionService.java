/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herique.services;

import herique.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hdias
 */

@Service
public class ExpressionService {

    @Autowired
    private ExpressionRepository service;

    public ExpressionRepository getService() {
        return service;
    }

    public void setService(ExpressionRepository service) {
        this.service = service;
    }
    
    
}
