package fr.iut.nd.pkdxapi.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fr.iut.nd.pkdxapi.errors.PkmnAlreadyExist;
import fr.iut.nd.pkdxapi.errors.PkmnNotFound;
import fr.iut.nd.pkdxapi.models.Pkmn;
import fr.iut.nd.pkdxapi.models.PkmnData;
import fr.iut.nd.pkdxapi.models.PkmnRegion;
import fr.iut.nd.pkdxapi.models.PkmnType;
import fr.iut.nd.pkdxapi.models.PkmnUpdater;
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

    public PkmnData addPkmn(Pkmn pkmn) {
        if(pkmnExist(pkmn.getName())) {
            throw new PkmnAlreadyExist("Pkmn already exists");
        }
        PkmnData pkmnData = new PkmnData(
            pkmn.getName(),
            pkmn.getDescription(),
            pkmn.getImgUrl(),
            pkmn.getPkmnType(),
            pkmn.getPkmnRegions()
        );
        return pkmnRepository.insert(pkmnData);
    }

    public PkmnData addRegionToPkmn(String pkmnName, PkmnRegion pkmnRegion) {
        if(!pkmnExist(pkmnName)){
            throw new PkmnNotFound("Pkmn not exist");
        }
        PkmnData existingPkmn = pkmnRepository.findByName(pkmnName);
        List<PkmnRegion> regions = existingPkmn.getPkmnRegions();

        boolean regionsExists = regions.stream()
        .anyMatch(region -> region.getRegionName()
        .equals(pkmnRegion.getRegionName()));

        if(regionsExists) {
            throw new PkmnAlreadyExist("Region already exists");
        }
        regions.add(pkmnRegion);
        existingPkmn.setPkmnRegions(regions);
        return pkmnRepository.save(existingPkmn);
    
    }



    public PkmnData removeRegionFromPkmn(String pkmnId, String regionName) {
        ObjectId pkmnIdObject = new ObjectId(pkmnId);
        PkmnData existingPkmn = pkmnExistByID(pkmnIdObject);
        if(existingPkmn == null) {
            throw new PkmnNotFound("Pkmn no exist");
        }
        List<PkmnRegion> regions = existingPkmn.getPkmnRegions();
        regions.removeIf(region -> region.getRegionName().equals(regionName));
        existingPkmn.setPkmnRegions(regions);
        return pkmnRepository.save(existingPkmn);
        
    }


    public PkmnData getPkmByIdOrName(String id, String name) {
        if((id == null || id.length() < 24 ) && name == null) throw new PkmnNotFound("Your params are not valid");
        
        if (id != null) {

            ObjectId pkmnIdObject = new ObjectId(id);
            PkmnData existingPkmn = pkmnExistByID(pkmnIdObject);
            if(existingPkmn == null) throw new PkmnNotFound("Pkmn no exist");
            return existingPkmn;
        } 
        if (name != null) {
            if(!pkmnExist(name)) throw new PkmnNotFound("Pkmn not exist");
            return pkmnRepository.findByName(name);
        }
        return null;
    }

    public void deletePkmn(String id) {
        ObjectId pkmnIdObject = new ObjectId(id);
        PkmnData existingPkmn = pkmnExistByID(pkmnIdObject);
        if(existingPkmn == null) throw new PkmnNotFound("Pkmn no exist");
        pkmnRepository.deleteById(pkmnIdObject);
    }

    public PkmnData updatePkmn(String id, PkmnUpdater pkmn) {
        
        ObjectId pkmnIdObject = new ObjectId(id);
        PkmnData existingPkmn = pkmnExistByID(pkmnIdObject);
        if(existingPkmn == null) throw new PkmnNotFound("Pkmn no exist");
        
        if(pkmn.getDescription() != null && pkmn.getDescription().length() > 0) existingPkmn.setDescription(pkmn.getDescription());
        if(pkmn.getImgUrl() != null && pkmn.getImgUrl().length() > 0) existingPkmn.setImgUrl(pkmn.getImgUrl());
        if(pkmn.getName() != null   && pkmn.getName().length() > 0) existingPkmn.setName(pkmn.getName());
        if(pkmn.getPkmnTypeOne() != null) existingPkmn.setTypeOne(pkmn.getPkmnTypeOne());
        if(pkmn.getPkmnTypeTwo() != null ) existingPkmn.setTypeTwo(pkmn.getPkmnTypeTwo());
        
        return pkmnRepository.save(existingPkmn);
        
    }



    public Map<String, Object> getPagedPkmnByPartialName(String partialName, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<PkmnData> pagedPkmn = pkmnRepository.findByPartialName(partialName, pageable);
        
        List<PkmnData> pkmnList = pagedPkmn.getContent();
        long totalPkmnCount = pagedPkmn.getNumberOfElements();
        Map<String, Object> response = new HashMap<>();
        response.put("data", pkmnList);
        response.put("count", totalPkmnCount);
        return response;
    }


    // ! PRIVATE FUNCTIONS

    private boolean pkmnExist(String name) {
        PkmnData pkmnIsExist = pkmnRepository.findByName(name);
        return pkmnIsExist != null;
    }

    private PkmnData pkmnExistByID(ObjectId id) {
        Optional<PkmnData> pkmnIsExist = pkmnRepository.findById(id);
        return pkmnIsExist.orElse(null);
    }


}
