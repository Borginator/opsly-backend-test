package simon.baptista.opslybackendtest

import org.junit.jupiter.api.Test
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import net.minidev.json.JSONArray
import org.hamcrest.CoreMatchers.isA


@SpringBootTest
@AutoConfigureMockMvc
class OpslyBackendTestApplicationTests {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun root_returns_status_is_OK() {
        mockMvc.perform(get("/")).andExpect(status().isOk)
    }

    @Test
    fun root_returns_json_with_social_network_fields() {
        mockMvc.perform(get("/"))
                .andExpect(jsonPath("$.facebook", isA(JSONArray::class.java)))
                .andExpect(jsonPath("$.twitter", isA(JSONArray::class.java)))
                .andExpect(jsonPath("$.instagram", isA(JSONArray::class.java)))
    }

}
