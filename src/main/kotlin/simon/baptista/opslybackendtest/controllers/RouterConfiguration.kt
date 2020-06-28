package simon.baptista.opslybackendtest.controllers

import kotlinx.coroutines.FlowPreview
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class RouterConfiguration {

    @Bean
    fun getWebClient(): WebClient = WebClient.create()

    @FlowPreview
    @Bean
    fun routes(summaryController: SummaryController) = coRouter {
        GET("/", summaryController::summary)
    }
}