package simon.baptista.opslybackendtest.requesters

import kotlinx.coroutines.reactive.awaitSingle
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import simon.baptista.opslybackendtest.content.FacebookStatus


@Component
class FacebookRequester(@Autowired var webClient: WebClient) {

    suspend fun getStatuses(): Array<FacebookStatus> =
        webClient.get().uri("/facebook").
        accept(MediaType.APPLICATION_JSON).retrieve()
                .bodyToMono<Array<FacebookStatus>>()
                .onErrorReturn(emptyArray())
                .awaitSingle()
}