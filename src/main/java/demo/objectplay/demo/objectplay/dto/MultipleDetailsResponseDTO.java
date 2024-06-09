package demo.objectplay.demo.objectplay.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MultipleDetailsResponseDTO {

    Object RestaurantAddress;
    Object RestaurantCategory;
    Object RestaurantCity;
    Object RestaurantCountry;
    Object PublisherKey;
    Object OwnerName;
}
