package fr.iut.nd.pkdxapi.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import fr.iut.nd.pkdxapi.models.Pkmn;
import fr.iut.nd.pkdxapi.models.PkmnData;
import fr.iut.nd.pkdxapi.models.PkmnType;
import fr.iut.nd.pkdxapi.repositories.PkmnRepository;

@Service
public class PkmnService {
    PkmnRepository pkmnRepository;

    public PkmnService(PkmnRepository pkmnRepository) {
        this.pkmnRepository = pkmnRepository;
    }



    public Map<String, Object> getAllPkmnTypes(){
    // get la liste des types
    List<String> types = Arrays
        .stream(PkmnType.values())
        .map(Enum::name)
        .collect(Collectors.toList());
    // créer le json de retour
    Map<String, Object> response = new HashMap<>();
    response.put("data", types);
    response.put("count", types.size());
    return response;
}

public void addPkmn(Pkmn pkmn) {
    PkmnData pkmnData = new PkmnData(
        pkmn.getName(),
        pkmn.getDescription(),
        pkmn.getImgUrl(),
        pkmn.getPkmnType(),
        pkmn.getPkmnRegions()
    );

    pkmnRepository.insert(pkmnData);
}
}


// public PkmnData createPkmn(PkmnInputData pkmnInputData) {
//     // Check if the Pokémon already exists
//     Optional<PkmnData> existingPkmn = pkmnRepository.findByName(pkmnInputData.getName());
//     if (existingPkmn.isPresent()) {
//         // Pokémon already exists, return the existing data
//         return existingPkmn.get();
//     } else {
//         // Pokémon does not exist, create a new one
//         PkmnData newPkmn = new PkmnData();
//         // Set the fields of newPkmn using pkmnInputData
//         // ...
//         PkmnData savedPkmn = pkmnRepository.save(newPkmn);
//         return savedPkmn;
//     }
// }