package com.escola.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola.model.Admin;
import com.escola.repository.AdminRepository;

@Service
public class AdminService {


    @Autowired
    private AdminRepository adR;

    public List<Admin> cadastrarListaAdmins(List<Admin> admins) {
        return adR.saveAll(admins);
    }
    
    public List<Admin> listarTodos() {
        return adR.findAll();
    }
    
    
}
