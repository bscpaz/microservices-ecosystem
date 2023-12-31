package br.com.bscpaz.desafio.adapters.primary.v1.http.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ResponseDto<T> {

    private int code;
    private String status;
    private List<String> messages = new ArrayList<>();
    private T result;

    public ResponseDto(T t, HttpStatus httpStatus) {
        this.result = t;
        this.code = httpStatus.value();
        this.status = httpStatus.getReasonPhrase();
    }

    public ResponseDto(HttpStatus httpStatus, String message) {
        this(null, httpStatus);
        this.messages.add(message);
    }

    public ResponseDto(T t, HttpStatus httpStatus, List<String> messages) {
        this(t, httpStatus);
        this.messages = messages;
    }

    public ResponseDto(HttpStatus httpStatus, List<String> messages) {
        this(null, httpStatus);
        this.messages = messages;
    }

    public ResponseDto(T t, HttpStatus httpStatus, String message) {
        this(t, httpStatus);
        this.messages.add(message);
    }
}
