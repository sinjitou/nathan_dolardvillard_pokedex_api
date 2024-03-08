package fr.iut.nd.pkdxapi.controllers;

import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.iut.nd.pkdxapi.models.Pkmn;
import fr.iut.nd.pkdxapi.models.PkmnData;
import fr.iut.nd.pkdxapi.models.PkmnRegion;
import fr.iut.nd.pkdxapi.models.PkmnType;
import fr.iut.nd.pkdxapi.models.PkmnUpdater;
import fr.iut.nd.pkdxapi.services.PkmnService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    // 2.1 - Add Pkmn
    @PostMapping
    public ResponseEntity<PkmnData> addPkmn(@RequestBody Pkmn pkmnInputData) {
        PkmnData newPkmn = service.addPkmn(pkmnInputData);
        return ResponseEntity.ok(newPkmn);
    }

    // 2.2 - add region
    @PutMapping("/region/{pkmnName}")
    public ResponseEntity<PkmnData> addRegionToPkmn(@PathVariable String pkmnName, @RequestBody PkmnRegion pkmnRegion) {
        PkmnData pkmn = service.addRegionToPkmn(pkmnName, pkmnRegion);
        return ResponseEntity.ok(pkmn);
    }

    // 2.7 - remove region
    @DeleteMapping("/region")
    public ResponseEntity<PkmnData> removeRegionFromPkmn(@RequestParam String pkmnID, @RequestParam String regionName) {
        PkmnData pkmn =  service.removeRegionFromPkmn(pkmnID, regionName);
        return ResponseEntity.ok(pkmn);
    }

    // 2.4 - Get one pkm by id or name
    @GetMapping
    public ResponseEntity<PkmnData> getPkmByIdOrName(@RequestParam(required = false) String id, @RequestParam(required = false) String name) {
        PkmnData pkmnInfo = service.getPkmByIdOrName(id, name);
        return ResponseEntity.ok(pkmnInfo);
    }

    // 2.5 - Delete pkm
    @DeleteMapping
    public ResponseEntity<Void> deletePkmn(@RequestParam String id) {
        service.deletePkmn(id);
        return ResponseEntity.noContent().build();
    }

    // 2.6 - Update pkm
    @PutMapping
    public ResponseEntity<PkmnData> updatePkmn(
        @RequestParam String id, 
        @RequestParam(required = false) Optional<PkmnType> typeOne, 
        @RequestParam(required = false) Optional<PkmnType> typeTwo, 
        @RequestParam(required = false) Optional<String> description, 
        @RequestParam(required = false) Optional<String> imgUrl, 
        @RequestParam(required = false) Optional<String> name
    ) {
        PkmnUpdater pkmnUpdater = new PkmnUpdater(
            name, 
            description, 
            imgUrl, 
            typeOne, 
            typeTwo
        );
        PkmnData updatedPkmn = service.updatePkmn(id, pkmnUpdater);
        return ResponseEntity.ok(updatedPkmn);
    }

    // 2.3 - Search pkmn (partialName, page and size)
    @GetMapping("/search")
    public ResponseEntity<Map<String, Object>> searchPkmnByPartialName(
            @RequestParam(defaultValue = "") String partialName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        
        Map<String, Object> response = service.getPagedPkmnByPartialName(partialName, page, size);
        return ResponseEntity.ok(response);
    }
    



}
