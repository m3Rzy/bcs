package ru.theft.bcs.util.handler;

import lombok.*;

@RequiredArgsConstructor
@Data
public class ErrorResponse {
    private final String title;
    private final Integer status;
    private final String desc;
}
