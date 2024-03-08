package fr.iut.nd.pkdxapi.models;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Document("Trainer")
@TypeAlias("TrainerData")
public class TrainerData extends Trainer {
    @Id
    @JsonSerialize(using= ToStringSerializer.class)
    protected ObjectId id;
    protected Date creationDate;

    public String getId() {
        return id.toHexString();
    }


    public TrainerData(String username, String imgUrl, String trainerName, List<String> pkmnSeen, List<String> pkmnCatch) {
        super(username, imgUrl, trainerName, pkmnSeen, pkmnCatch);
        id = ObjectId.get();
        creationDate = new Date();
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getUsername() {
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
}
