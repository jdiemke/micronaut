package io.github.jdiemke.micronaut;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/hello")
public class HelloController {

    @Get("/")
    public Message helloWorld() {
        Message message = new Message();
        message.setMessage("Hello World!");
        return message;
    }

}
