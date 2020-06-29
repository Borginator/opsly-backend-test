package simon.baptista.opslybackendtest

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.test.web.reactive.server.WebTestClient


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@ImportAutoConfiguration
@Import(MyTestConfiguration::class)
class OpslyBackendTestApplicationTests() {


    @Autowired lateinit var testClient: WebTestClient

    @Test
    fun root_returns_status_is_OK() {
        testClient.get().uri("/").exchange().expectStatus().isOk
    }

    @Test
    fun root_returns_json_with_social_network_fields() {
//        JSONObject()
//        mockMvc.perform(get("/"))
//                .andExpect(jsonPath("$.facebook", isA(JSONArray::class.java)))
//                .andExpect(jsonPath("$.twitter", isA(JSONArray::class.java)))
//                .andExpect(jsonPath("$.instagram", isA(JSONArray::class.java)))
    }

}
