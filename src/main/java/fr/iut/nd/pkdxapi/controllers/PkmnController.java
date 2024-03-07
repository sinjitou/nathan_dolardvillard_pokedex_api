package fr.iut.nd.pkdxapi.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import fr.iut.nd.pkdxapi.models.Pkmn;
import fr.iut.nd.pkdxapi.models.PkmnData;
import fr.iut.nd.pkdxapi.services.PkmnService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/pkmn")
public class PkmnController {
    private PkmnService service;
    public PkmnController(PkmnService service){
        this.service = service;
    }

    @GetMapping("/types")
    public ResponseEntity<Map<String, Object>> getPokemonTypes() {
        Map<String, Object> response = service.getAllPkmnTypes();
        return ResponseEntity.ok(response);
    }

    @PostMapping()
    public ResponseEntity<String> addPkmn(@RequestPart Pkmn pkmnInputData) {
        service.addPkmn(pkmnInputData);
        return ResponseEntity.ok("Pkmn added successfully");
    }
    



}
