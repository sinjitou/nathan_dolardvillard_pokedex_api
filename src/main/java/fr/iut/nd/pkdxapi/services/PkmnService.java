package fr.iut.nd.pkdxapi.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import fr.iut.nd.pkdxapi.models.PkmnType;

@Service
public class PkmnService {


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
}
