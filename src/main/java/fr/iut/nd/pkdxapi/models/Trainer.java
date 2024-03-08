package fr.iut.nd.pkdxapi.models;

import java.util.List;

import org.springframework.data.annotation.TypeAlias;

@TypeAlias("Trainer")
public class Trainer {

    protected String username;
    protected String imgUrl;
    protected String trainerName;
    protected List<String> pkmnSeen;
    protected List<String> pkmnCatch;


    public Trainer(String username, String imgUrl, String trainerName,List<String> pkmnSeen, List<String> pkmnCatch) {
        this.username = username;
        this.imgUrl = imgUrl;
        this.trainerName = trainerName;
        this.pkmnSeen = pkmnSeen;
        this.pkmnCatch = pkmnCatch;
    }

    public String getUserName() {
        return username;
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

    public void setUserName(String username) {
        this.username = username;
    }




    
}
