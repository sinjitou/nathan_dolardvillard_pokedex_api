package fr.iut.nd.pkdxapi.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.iut.nd.pkdxapi.services.PkmnService;

@RestController
public class PkmnController {
    private PkmnService service;
    public PkmnController(PkmnService service){
        this.service = service;
    }

    @GetMapping("/pkmn/types")
    public ResponseEntity<Map<String, Object>> getPokemonTypes() {
        Map<String, Object> response = service.getAllPkmnTypes();
        return ResponseEntity.ok(response);
    }

}
