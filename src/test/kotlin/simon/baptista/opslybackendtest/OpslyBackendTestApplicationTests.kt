package simon.baptista.opslybackendtest

import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.web.reactive.function.client.WebClient
import java.net.InetAddress


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@ImportAutoConfiguration
class OpslyBackendTestApplicationTests() {

    class TestDispatcher: Dispatcher() {
        override fun dispatch(request: RecordedRequest): MockResponse {
            return MockResponse().setResponseCode(200)
        }
    }


    @Autowired lateinit var testClient: WebTestClient
    lateinit var mockWebServer: MockWebServer

//    @BeforeAll
//    fun setUp() {
//        mockWebServer = MockWebServer()
//        mockWebServer.dispatcher = TestDispatcher()
////        mockWebServer.start(InetAddress.getByName("https://takehome.io"))
//    }
//
//    @AfterAll
//    fun tearDown() {
//        mockWebServer.shutdown()
//    }

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
