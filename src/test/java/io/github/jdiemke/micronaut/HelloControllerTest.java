package io.github.jdiemke.micronaut;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@MicronautTest
@DisplayName("HelloController Test")
public class HelloControllerTest {

    @Inject
    @Client("/")
    RxHttpClient client;

    @Test
    @DisplayName("Should return \"Hello World\" when accessing /hello endpoint")
    public void shouldReturnHelloWorld() throws Exception {
        final Message result = client.toBlocking().retrieve("/hello", Message.class);

        Assertions.assertEquals("Hello World!", result.getMessage());
    }

}
