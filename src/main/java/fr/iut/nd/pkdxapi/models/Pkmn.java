package fr.iut.nd.pkdxapi.models;

import java.util.List;

import org.springframework.data.annotation.TypeAlias;

@TypeAlias("Pkmn")
public class Pkmn {

    private String name;
    private String description;
    private String imgUrl;
    private List<PkmnType> PkmnType;
    private List<PkmnRegion> PkmnRegion;


    public Pkmn(String name, String description, String imgUrl, List<PkmnType> PkmnType, List<PkmnRegion> PkmnRegion) {
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.PkmnType = PkmnType;
        this.PkmnRegion = PkmnRegion;
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
        return PkmnType;
    }

    public List<PkmnRegion> getPkmnRegions() {
        return PkmnRegion;
    }


    
}
