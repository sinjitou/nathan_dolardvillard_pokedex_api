package fr.iut.nd.pkdxapi.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import fr.iut.nd.pkdxapi.models.PkmnData;


@Repository
public interface PkmnRepository extends MongoRepository<PkmnData, ObjectId> {

}
