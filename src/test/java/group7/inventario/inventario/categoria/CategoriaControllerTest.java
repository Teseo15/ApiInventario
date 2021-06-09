package group7.inventario.inventario.categoria;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class CategoriaControllerTest {

    private static final ObjectMapper om = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testGetCategoria() throws Exception {

        //int NRO_RECORD = 73;
        int ID_FIRST_RECORD = 1;
        this.mockMvc.perform(get("/categoria/all"))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentType(MediaType.APPLICATION_JSON))
                //    .andExpect(jsonPath("$", hasSize(NRO_RECORD)))
                .andExpect(jsonPath("$[0].id", is(ID_FIRST_RECORD)));
    }

    @Test
    public void testCreateCategoria() throws Exception {

        String NAME = "Cereales";

        Categoria categoria =new Categoria(NAME);
        mockMvc.perform(post("/categoria/add")
                .content(om.writeValueAsString(categoria))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                //.andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nombre", is(NAME)));

    }
}
