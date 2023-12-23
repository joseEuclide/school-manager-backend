package com.escola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.escola.model.Admin;
import com.escola.service.AdminService;

@RestController
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private AdminService adS;


    @PostMapping("/cadastrar-admin")
    public ResponseEntity<Admin> cadastrarAdmin(@RequestBody Admin admin) {
        Admin cadastrado = adS.cadastrarUmAdmin(admin);
        return ResponseEntity.ok(cadastrado);
    }
    
    @PostMapping("/cadastrar-admins")
    public ResponseEntity<List<Admin>> cadastrarAdmins(@RequestBody List<Admin> admins) {
        List<Admin> cadastrados = adS.cadastrarListaAdmins(admins);
        return ResponseEntity.ok(cadastrados);
    }

    @GetMapping("/listar-admins")
    public ResponseEntity<List<Admin>> listarTodosAdmins() {
        List<Admin> tesoureiros = adS.listarTodos();
        return ResponseEntity.ok(tesoureiros);
    }

    // Outros endpoints para cadastrar, atualizar, deletar, buscar por ID, etc.
}

