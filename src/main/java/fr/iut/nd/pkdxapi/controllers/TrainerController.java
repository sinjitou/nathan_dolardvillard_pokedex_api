package fr.iut.nd.pkdxapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.iut.nd.pkdxapi.models.TrainerDTO;
import fr.iut.nd.pkdxapi.models.TrainerData;
import fr.iut.nd.pkdxapi.services.TrainerService;

@RestController
@RequestMapping("/trainer")
public class TrainerController {

    private final TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @PostMapping
    public ResponseEntity<TrainerData> createTrainer(@RequestBody TrainerDTO trainer) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        TrainerData createdTrainer = trainerService.createTrainer(trainer, username);
        return ResponseEntity.ok(createdTrainer);
    }

    @GetMapping
    public ResponseEntity<TrainerData> getTrainer() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        TrainerData trainer = trainerService.getTrainer(username);
        return ResponseEntity.ok(trainer);
    }


    @DeleteMapping
    public ResponseEntity<Void> deleteTrainer() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        trainerService.deleteTrainer(username);
        return ResponseEntity.noContent().build();
    }
}