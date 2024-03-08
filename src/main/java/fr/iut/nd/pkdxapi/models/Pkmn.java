package fr.iut.nd.pkdxapi.models;

import java.util.List;

import org.springframework.data.annotation.TypeAlias;

@TypeAlias("Pkmn")
public class Pkmn {

    protected String name;
    protected String description;
    protected String imgUrl;
    protected List<PkmnType> types;
    protected List<PkmnRegion> regions;


    public Pkmn(String name, String description, String imgUrl, List<PkmnType> types, List<PkmnRegion> regions) {
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.types = types;
        this.regions = regions;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public List<PkmnType> getPkmnType() {
        return types;
    }

    public List<PkmnRegion> getPkmnRegions() {
        return regions;
    }


    
}
