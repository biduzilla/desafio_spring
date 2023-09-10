package com.ricky.desafio_spring.error;

import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
public class ApiError {
    @Getter
    private List<String> error;

    public ApiError(String msgError) {
        this.error = List.of(msgError);
    }

    public ApiError(List<String> error) {
        this.error = error;
    }
}
