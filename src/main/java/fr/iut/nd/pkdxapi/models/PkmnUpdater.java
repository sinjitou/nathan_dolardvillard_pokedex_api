package fr.iut.nd.pkdxapi.models;


import java.util.Optional;

import org.springframework.data.annotation.TypeAlias;

@TypeAlias("PkmnUpdater")
public class PkmnUpdater {

    protected Optional<String> name;
    protected Optional<String> description;
    protected Optional<String> imgUrl;
    protected Optional<PkmnType> typeOne;
    protected Optional<PkmnType> typeTwo;


    public PkmnUpdater(Optional<String> name, Optional<String> description, Optional<String> imgUrl, Optional<PkmnType> typeOne, Optional<PkmnType> typeTwo) {
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.typeOne = typeOne;
        this.typeTwo = typeTwo;
    }

    public String getName() {
        return name.orElse(null);
    }

    public String getDescription() {
        return description.orElse(null);
    }

    public String getImgUrl() {
        return imgUrl.orElse(null);
    }

    public PkmnType getPkmnTypeOne() {
        return typeOne.orElse(null);
    }

    public PkmnType getPkmnTypeTwo() {
        return typeTwo.orElse(null);
    }


    
}
