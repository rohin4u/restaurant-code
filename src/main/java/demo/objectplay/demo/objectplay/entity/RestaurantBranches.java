package demo.objectplay.demo.objectplay.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RestaurantBranches {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID branchesId;

    String branchesName;
}
