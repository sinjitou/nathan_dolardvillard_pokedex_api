package fr.iut.nd.pkdxapi.models;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Document("Pkmn")
@TypeAlias("PkmnData")
public class PkmnData extends Pkmn {
    @Id
    @JsonSerialize(using= ToStringSerializer.class)
    protected ObjectId id;

    public String getId() {
        return id.toHexString();
    }

    

    public PkmnData(String name, String description, String imgUrl, List<PkmnType> types, List<PkmnRegion> regions) {
        super(name, description, imgUrl, types, regions);
        id = ObjectId.get();
    }

    public void setPkmnRegions(List<PkmnRegion> regions) {
        this.regions = regions;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setTypeOne(PkmnType type) {
        this.types.remove(0);
        this.types.add(0, type);
    }

    public void setTypeTwo(PkmnType type) {
        this.types.remove(1);
        this.types.add(1, type);
    }

}

