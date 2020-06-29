package simon.baptista.opslybackendtest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@SpringBootApplication
class OpslyBackendTestApplication

@Configuration
class WebClientConfiguration {

    @Bean
    fun webClient() = WebClient.create("https://takehome.io")

}

fun main(args: Array<String>) {
    runApplication<OpslyBackendTestApplication>(*args)
}
