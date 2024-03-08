package fr.iut.nd.pkdxapi.repositories;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import fr.iut.nd.pkdxapi.models.TrainerData;


@Repository
public interface TrainerRepository extends MongoRepository<TrainerData, ObjectId> {

    @Query("{username: ?0}")
    TrainerData findByUsername(String username);

    @DeleteQuery("{username: ?0}")
    void deleteByUserName(String username);
}
