package br.com.alelo.consumer.consumerpat.app.handler;

public class EntidadeNaoEncontrada extends RuntimeException {
    public EntidadeNaoEncontrada(String message) {
        super(message);
    }
}