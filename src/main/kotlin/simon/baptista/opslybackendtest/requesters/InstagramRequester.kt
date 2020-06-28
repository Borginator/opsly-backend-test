package simon.baptista.opslybackendtest.requesters

import kotlinx.coroutines.flow.Flow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToFlow
import simon.baptista.opslybackendtest.content.InstagramPhoto

@RestController
class InstagramRequester(@Autowired var webClient: WebClient) {

    suspend fun getInstagramPhotos(): Flow<Array<InstagramPhoto>> = webClient.get().uri("https://takehome.io/instagram").
    accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlow()
}