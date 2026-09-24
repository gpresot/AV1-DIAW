package com.example.CandidatosTSE.controller;

import com.example.CandidatosTSE.model.Candidato;
import com.example.CandidatosTSE.service.CandidatosTseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;


@Controller
public class CandidatosTseController{

    private final CandidatosTseService candidatosTseService;

    public CandidatosTseController(CandidatosTseService candidatosTseService){
        this.candidatosTseService =  candidatosTseService;
    }

    @GetMapping("/")
    public String index(

        @RequestParam(required = false ) String cargo,
        @RequestParam(required = false) String partido,
        @RequestParam(required = false) String texto,
        Model model) {
            List<Candidato> candidato = candidatosTseService.filtrar(cargo,partido, texto);

            for (int i = 0; i < candidato.size(); i++){
                candidato.get(i).getNomeCandidato();
                candidato.get(i).getNrCandidato();
                candidato.get(i).getCargo();
                candidato.get(i).getSiglaPartido();
                candidato.get(i).getNomePartido();
                candidato.get(i).getIdade();
                

            }

            return "";

                
        }
    
    
    
    
    }
