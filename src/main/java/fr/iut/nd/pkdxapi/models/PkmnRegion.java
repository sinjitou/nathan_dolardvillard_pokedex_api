package fr.iut.nd.pkdxapi.models;

import org.springframework.data.annotation.TypeAlias;

@TypeAlias("PkmnRegion")
public class PkmnRegion {
    private String regionName;
    private Integer regionPokedexNumber;


    public PkmnRegion(String regionName, Integer regionPokedexNumber) {
        this.regionName = regionName;
        this.regionPokedexNumber = regionPokedexNumber;
    }

    public String getRegionName() {
        return regionName;
    }

    public Integer getRegionPokedexNumber() {
        return regionPokedexNumber;
    }

    
}
