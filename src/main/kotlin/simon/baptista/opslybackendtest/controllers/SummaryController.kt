package simon.baptista.opslybackendtest.controllers

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
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
    fun getSummary(): Deferred<Summary> {
        val statuses: Deferred<Array<FacebookStatus>> = GlobalScope.async { facebookRequester.getStatuses() }
        val tweets: Deferred<Array<Tweet>> = GlobalScope.async { twitterRequester.getTweets() }
        val photos: Deferred<Array<InstagramPhoto>> = GlobalScope.async { instagramRequester.getInstagramPhotos() }
        return GlobalScope.async { Summary(statuses.await(), tweets.await(), photos.await()) }
    }

}