package simon.baptista.opslybackendtest.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import simon.baptista.opslybackendtest.content.FacebookStatus
import simon.baptista.opslybackendtest.content.InstagramPhoto
import simon.baptista.opslybackendtest.content.Tweet

data class Summary(val facebook: Array<FacebookStatus>, val twitter: Array<Tweet>, val instagram: Array<InstagramPhoto>)

@RestController
class SummaryController {

    @GetMapping("/")
    fun summary() = Summary(emptyArray(), emptyArray(), emptyArray())

}