package com.escola.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.escola.model.PrecoPropina;
import com.escola.service.PrecoPropinaService;

@RestController
@CrossOrigin(origins = "*")
public class PrecoPropinaController {
    @Autowired
    private PrecoPropinaService pps;
    
    
    
   

    @GetMapping(value =  "/precos-das-propinas-1", produces="application/json")
    public List<PrecoPropina> listarTodosPrecos() {
        return pps.listarTodosPrecos();
    }

    

    @PostMapping(value="/precos-das-propinas-2", consumes="application/json")
    public List<PrecoPropina> cadastrarPrecos(@RequestBody List<PrecoPropina> precos) {
        return pps.cadastrarPrecos(precos);
    }

    

}
