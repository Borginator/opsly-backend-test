package simon.baptista.opslybackendtest.controllers

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyAndAwait

import simon.baptista.opslybackendtest.content.FacebookStatus
import simon.baptista.opslybackendtest.content.InstagramPhoto
import simon.baptista.opslybackendtest.content.Tweet
import simon.baptista.opslybackendtest.requesters.FacebookRequester
import simon.baptista.opslybackendtest.requesters.InstagramRequester
import simon.baptista.opslybackendtest.requesters.TwitterRequester

data class Summary(val facebook: Array<FacebookStatus>, val twitter: Array<Tweet>, val instagram: Array<InstagramPhoto>)

@Component
class SummaryController(@Autowired var facebookRequester: FacebookRequester,
                        @Autowired var twitterRequester: TwitterRequester,
                        @Autowired var instagramRequester: InstagramRequester) {

    suspend fun summary(request: ServerRequest): ServerResponse = ServerResponse.ok().bodyAndAwait(getSummary())

    private suspend fun getSummary(): Flow<Summary> {
        return combine(
                facebookRequester.getStatuses(),
                twitterRequester.getTweets(),
                instagramRequester.getInstagramPhotos()
        ) {
            statuses, tweets, photos -> Summary(statuses, tweets, photos)
        }
    }

}