package fr.iut.nd.pkdxapi.models;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Pkmn")
@TypeAlias("PkmnData")
public class PkmnData extends Pkmn {
    @Id
    protected ObjectId id;

    public PkmnData(String name, String description, String imgUrl, List<PkmnType> PkmnType, List<PkmnRegion> PkmnRegion) {
        super(name, description, imgUrl, PkmnType, PkmnRegion);
        id = ObjectId.get();
    }


}

