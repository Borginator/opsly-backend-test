package simon.baptista.opslybackendtest.requesters

import kotlinx.coroutines.flow.Flow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToFlow
import simon.baptista.opslybackendtest.content.Tweet

@RestController
class TwitterRequester(@Autowired var webClient: WebClient) {

    suspend fun getTweets(): Flow<Array<Tweet>> = webClient.get().uri("https://takehome.io/twitter").
    accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlow()
}