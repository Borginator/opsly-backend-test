package simon.baptista.opslybackendtest.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

data class Summary(val id: Long, val content: String)

@RestController
class SummaryController {

    @GetMapping("/")
    fun summary() = Summary(1, "hello, world")

}