package demo.objectplay.demo.objectplay.controller;

import demo.objectplay.demo.objectplay.dto.*;
import demo.objectplay.demo.objectplay.service.RestaurantServiceImpl;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class RestaurantController {

    RestaurantServiceImpl service;

    @Autowired
    public RestaurantController(RestaurantServiceImpl service){
        this.service=service;
    }


    @PostMapping("/enter-pin")
    public ResponseEntity<?> getRestWithPincode(@RequestBody RestpinDTO restpin){
        GlobalResponse<List<RestaurantPincodeDTO>> restaurantForPincode = service.getRestaurantForPincode(restpin.getPincode());
        return ResponseEntity.ok(restaurantForPincode);
    }

    @PostMapping("/multiple-restaurant")
    public ResponseEntity<?> getMultipleRestaurant
            (@RequestBody MultipleDetailsForUIRequestDTO multipleDetailsForUI){
        GlobalResponse<List<MultipleDetailsResponseDTO>> detailsOnMultipleParameters = service.getDetailsOnMultipleParameters(multipleDetailsForUI);
        return ResponseEntity.ok(detailsOnMultipleParameters);

    }
}
