package fr.iut.nd.pkdxapi.models;

import java.util.List;
import java.util.Optional;

import org.springframework.data.annotation.TypeAlias;

@TypeAlias("TrainerDTO")
public class TrainerDTO {

    protected Optional<String> username;
    protected String imgUrl;
    protected String trainerName;
    protected List<String> pkmnSeen;
    protected List<String> pkmnCatch;


    public TrainerDTO(Optional<String> username, String imgUrl, String trainerName,List<String> pkmnSeen, List<String> pkmnCatch) {
        this.username = username;
        this.imgUrl = imgUrl;
        this.trainerName = trainerName;
        this.pkmnSeen = pkmnSeen;
        this.pkmnCatch = pkmnCatch;
    }

    public String getUserName() {
        return username.orElse(null);
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public List<String> getPkmnSeen() {
        return pkmnSeen;
    }

    public List<String> getPkmnCatch() {
        return pkmnCatch;
    }

    public void setUserName(Optional<String> username) {
        this.username = username;
    }




    
}
