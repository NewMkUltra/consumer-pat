package br.com.alelo.consumer.consumerpat.app.handler;

import br.com.alelo.consumer.consumerpat.app.handler.EntidadeNaoEncontrada;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/throw-entity-not-found")
    public void throwEntityNotFound() {
        throw new EntidadeNaoEncontrada("Entity not found");
    }

    @GetMapping("/throw-illegal-argument")
    public void throwIllegalArgumentException() {
        throw new IllegalArgumentException("Illegal argument exception");
    }

    @GetMapping("/throw-runtime")
    public void throwRuntimeException() {
        throw new RuntimeException("Runtime exception");
    }
}