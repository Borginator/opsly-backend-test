package simon.baptista.opslybackendtest

import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.web.reactive.function.client.WebClient

@TestConfiguration
class MyTestConfiguration {
    @Bean
    fun testWebClient() = WebClient.builder().baseUrl(mockWebServer().url("/").toString()).build()

    @Bean
    fun mockWebServer(): MockWebServer {
        val mockWebServer = MockWebServer()
        mockWebServer.dispatcher = TestDispatcher()
        return mockWebServer
    }

    class TestDispatcher: Dispatcher() {
        override fun dispatch(request: RecordedRequest): MockResponse {
            println("Call made to ${request.requestUrl}")
            return MockResponse().setResponseCode(200)
        }
    }
}