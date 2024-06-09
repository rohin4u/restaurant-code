package demo.objectplay.demo.objectplay.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RestaurantPincodeDTO {

    String pincode;
    String restId;
    String restAddress;
    String restCity;
    String restKeys;
}
