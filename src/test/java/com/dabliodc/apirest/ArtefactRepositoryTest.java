package com.dabliodc.apirest;

import com.dabliodc.apirest.model.Artefact;
import com.dabliodc.apirest.repository.ArtefactRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class ArtefactRepositoryTest {
    @Autowired
    private TestEntityManager manager;

    @Autowired
    private ArtefactRepository artefactRepository;

    @Test
    public void loadingArtefactTest() {
        String nameArtefact = "Wellington";

        Artefact artefactTest = new Artefact("123","20210912", "Wellington", "test", "test", "test");
        manager.persist(artefactTest);

        List<Artefact> artefact = artefactRepository.findByName(nameArtefact);
        Assert.assertNotNull(artefact);
        Assert.assertEquals(nameArtefact, artefact.get(0).getName());
    }
}
