package fr.iut.nd.pkdxapi.services;

import org.springframework.stereotype.Service;

import fr.iut.nd.pkdxapi.errors.TrainerAlreadyExist;
import fr.iut.nd.pkdxapi.models.TrainerDTO;
import fr.iut.nd.pkdxapi.models.TrainerData;
import fr.iut.nd.pkdxapi.repositories.TrainerRepository;

@Service
public class TrainerService {

    private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public TrainerData createTrainer(TrainerDTO trainer, String username) {

        if (isTrainerExist(username)) {
            throw new TrainerAlreadyExist("Trainer already exist");
        }

        TrainerData newTrainer = new TrainerData(username, trainer.getImgUrl(), trainer.getTrainerName(), trainer.getPkmnSeen(), trainer.getPkmnCatch());
        return trainerRepository.insert(newTrainer);
    }

    public TrainerData getTrainer(String username) {
        return trainerRepository.findByUsername(username);
    }

    public void deleteTrainer(String username) {
        trainerRepository.deleteByUserName(username);
    }

    private boolean isTrainerExist(String username) {
        return trainerRepository.findByUsername(username) != null;
    }

    // TODO : PUT request trainer
}
