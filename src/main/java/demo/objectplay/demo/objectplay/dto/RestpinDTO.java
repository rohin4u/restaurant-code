package demo.objectplay.demo.objectplay.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.logging.Level;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class
RestpinDTO {

    String pincode;
}
