package demo.objectplay.demo.objectplay.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MultipleDetailsForUIRequestDTO {

    String fromDate;
    String toDate;
    String postalCode;
    String province;

}
