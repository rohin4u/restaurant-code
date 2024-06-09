package demo.objectplay.demo.objectplay.dto;

import demo.objectplay.demo.objectplay.exception.ErrorResponse;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GlobalResponse<T> {

    String message;
    T data;
    ErrorResponse error;
}
