package com.demo.appone.product;

import com.demo.appone.ApponeApplication;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = ApponeApplication.class)
@AutoConfigureMockMvc
public class ProductResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetProducts() throws Exception {
        String expectedResult = """
                [
                    {
                        "id": 1,
                        "name": "NoteBook Ruled",
                        "description": "80 pages ruled notebook"
                    },
                    {
                        "id": 2,
                        "name": "NoteBook UnRuled",
                        "description": "80 pages un-ruled notebook"
                    }
                ]
                                """;
        mockMvc.perform(MockMvcRequestBuilders.get("/products")).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().json(expectedResult));
    }

}
