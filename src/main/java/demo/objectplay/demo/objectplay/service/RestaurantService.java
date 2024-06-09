package demo.objectplay.demo.objectplay.service;

import demo.objectplay.demo.objectplay.dto.GlobalResponse;
import demo.objectplay.demo.objectplay.dto.MultipleDetailsForUIRequestDTO;

public interface RestaurantService<T> {

    public GlobalResponse<T> getRestaurantForPincode(String pincode);

    public GlobalResponse<T> getDetailsOnMultipleParameters(MultipleDetailsForUIRequestDTO multipleDetailsForUI);
}
