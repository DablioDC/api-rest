package com.dabliodc.apirest.repository;

import com.dabliodc.apirest.model.Artefact;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtefactRepository extends MongoRepository<Artefact, String> {
    List<Artefact> findByName(String name);
}
