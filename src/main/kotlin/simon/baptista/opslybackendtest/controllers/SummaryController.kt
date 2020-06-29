package simon.baptista.opslybackendtest.controllers

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

import simon.baptista.opslybackendtest.content.FacebookStatus
import simon.baptista.opslybackendtest.content.InstagramPhoto
import simon.baptista.opslybackendtest.content.Tweet
import simon.baptista.opslybackendtest.requesters.FacebookRequester
import simon.baptista.opslybackendtest.requesters.InstagramRequester
import simon.baptista.opslybackendtest.requesters.TwitterRequester

data class Summary(val facebook: Array<FacebookStatus>, val twitter: Array<Tweet>, val instagram: Array<InstagramPhoto>)

@RestController
class SummaryController(@Autowired var facebookRequester: FacebookRequester,
                        @Autowired var twitterRequester: TwitterRequester,
                        @Autowired var instagramRequester: InstagramRequester) {


    @GetMapping("/")
    fun getSummary(): Deferred<Summary?> {
        return GlobalScope.async {
            combine(
                    facebookRequester.getStatuses(),
                    twitterRequester.getTweets(),
                    instagramRequester.getInstagramPhotos()
            ) { statuses, tweets, photos ->
                Summary(statuses, tweets, photos)
            }.singleOrNull()
        }
    }

}