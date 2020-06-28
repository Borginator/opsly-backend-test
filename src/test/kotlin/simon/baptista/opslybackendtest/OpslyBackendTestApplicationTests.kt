package simon.baptista.opslybackendtest

import org.junit.jupiter.api.Test
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@SpringBootTest
@AutoConfigureMockMvc
class OpslyBackendTestApplicationTests {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun root_returns_status_is_OK() {
        mockMvc.perform(get("/")).andExpect(status().isOk)
    }

}
