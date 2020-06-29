package simon.baptista.opslybackendtest.requesters

import kotlinx.coroutines.flow.Flow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToFlow
import simon.baptista.opslybackendtest.content.FacebookStatus


@Component
class FacebookRequester(@Autowired var webClient: WebClient) {

    fun getStatuses(): Flow<Array<FacebookStatus>> =
        webClient.get().uri("https://takehome.io/facebook").
        accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlow()
}