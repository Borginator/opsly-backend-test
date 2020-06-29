package simon.baptista.opslybackendtest.requesters

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.awaitSingle
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import org.springframework.web.reactive.function.client.bodyToFlow
import org.springframework.web.reactive.function.client.bodyToMono
import simon.baptista.opslybackendtest.content.InstagramPhoto
import simon.baptista.opslybackendtest.content.Tweet

@Component
class TwitterRequester(@Autowired var webClient: WebClient) {

    suspend fun getTweets(): Array<Tweet> = webClient.get().uri("https://takehome.io/twitter").
    accept(MediaType.APPLICATION_JSON).retrieve()
            .bodyToMono<Array<Tweet>>()
            .onErrorReturn(emptyArray())
            .awaitSingle()
}