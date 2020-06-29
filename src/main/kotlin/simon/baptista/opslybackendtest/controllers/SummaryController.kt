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
        return GlobalScope.async {
            val statuses= facebookRequester.getStatuses()
            val tweets= twitterRequester.getTweets()
            val photos =  instagramRequester.getInstagramPhotos()
            Summary(statuses, tweets, photos)
        }
    }

}