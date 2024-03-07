package fr.iut.nd.pkdxapi.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;

@TypeAlias("PkmnRegion")
public class PkmnRegion {
    private String regionName;
    private Integer regionNumber;


    public PkmnRegion(String regionName, Integer regionNumber) {
        this.regionName = regionName;
        this.regionNumber = regionNumber;
    }

    public String getRegionName() {
        return regionName;
    }

    public Integer getRegionNumber() {
        return regionNumber;
    }

    
}
