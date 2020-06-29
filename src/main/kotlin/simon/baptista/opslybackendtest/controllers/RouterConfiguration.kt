package simon.baptista.opslybackendtest.controllers

import kotlinx.coroutines.FlowPreview
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class RouterConfiguration {

    @FlowPreview
    @Bean
    fun route(summaryController: SummaryController) = coRouter {
        accept(MediaType.ALL).nest {
            GET("/", summaryController::summary)
        }
    }
}