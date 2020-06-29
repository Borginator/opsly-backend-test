package simon.baptista.opslybackendtest

import kotlinx.coroutines.FlowPreview
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.server.coRouter
import simon.baptista.opslybackendtest.controllers.SummaryController

@SpringBootApplication
class OpslyBackendTestApplication

@Configuration
class WebClientConfiguration {

    @Bean
    fun webClient() = WebClient.create()

}

fun main(args: Array<String>) {
    runApplication<OpslyBackendTestApplication>(*args)
}
