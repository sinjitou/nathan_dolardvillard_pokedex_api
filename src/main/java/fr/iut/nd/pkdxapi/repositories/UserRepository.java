package fr.iut.nd.pkdxapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import fr.iut.nd.pkdxapi.models.UserData;

@Repository
public interface UserRepository extends MongoRepository<UserData, String> {
    
    @Query("{login: ?0}")
    UserData findByUsername(String username);
}
