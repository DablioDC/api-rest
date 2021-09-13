package com.dabliodc.apirest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.net.URI;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArtefactControllerTest {

    private MockMvc mockMvc;

    @Test
    public void testFindaAllData() throws Exception {
        URI uri = new URI("/artefacts");
        String json = ""; // Caso precise de um json, dá para montar manual mesmo e enviar.

        mockMvc.perform(MockMvcRequestBuilders
                .get(uri)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200));
    }

}
