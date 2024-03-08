package fr.iut.nd.pkdxapi.repositories;


import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import fr.iut.nd.pkdxapi.models.PkmnData;


@Repository
public interface PkmnRepository extends MongoRepository<PkmnData, ObjectId> {

    @Query("{name: ?0}")
    PkmnData findByName(String name);

    @Query("{'name': {$regex : ?0, $options: 'i'}}")
    Page<PkmnData> findByPartialName(String partialName, Pageable pageable);
}
