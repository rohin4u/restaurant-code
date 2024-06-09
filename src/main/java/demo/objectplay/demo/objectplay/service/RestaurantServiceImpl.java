package demo.objectplay.demo.objectplay.service;

import demo.objectplay.demo.objectplay.dto.GlobalResponse;
import demo.objectplay.demo.objectplay.dto.MultipleDetailsForUIRequestDTO;
import demo.objectplay.demo.objectplay.dto.MultipleDetailsResponseDTO;
import demo.objectplay.demo.objectplay.dto.RestaurantPincodeDTO;
import demo.objectplay.demo.objectplay.repository.RestaurantBranchesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    RestaurantBranchesRepo repo;

    @Autowired
    public RestaurantServiceImpl(RestaurantBranchesRepo repo){
        this.repo=repo;
    }
    @Override
    public GlobalResponse<List<RestaurantPincodeDTO>> getRestaurantForPincode(String pincode) {

        List<Object[]> restaurantForPincode = repo.getRestaurantForPincode(pincode);
        List<RestaurantPincodeDTO> pincodeDto = new ArrayList<>();

        for(Object[] o : restaurantForPincode) {
            RestaurantPincodeDTO dto = new RestaurantPincodeDTO();
            dto.setPincode(o[0].toString());
            dto.setRestId(o[1].toString());
            dto.setRestAddress(o[2].toString());
            dto.setRestCity(o[3].toString());
            dto.setRestKeys(o[4].toString());
            pincodeDto.add(dto);

        }

        GlobalResponse<List<RestaurantPincodeDTO>> response = new GlobalResponse<>();
        response.setData(pincodeDto);
        response.setError(null);
        response.setMessage("success");


        return response;
    }

    @Override
    public GlobalResponse<List<MultipleDetailsResponseDTO>> getDetailsOnMultipleParameters(MultipleDetailsForUIRequestDTO multipleDetailsForUI) {

        List<Object[]> detailsBasedOnMultipleDBResponse =null;
        if((multipleDetailsForUI.getFromDate()!=null && multipleDetailsForUI.getToDate()!=null) ||
        multipleDetailsForUI.getToDate()==null && multipleDetailsForUI.getFromDate()==null) {

            detailsBasedOnMultipleDBResponse = repo.getDetailsBasedOnMultipleParameters(multipleDetailsForUI.getFromDate(),
                    multipleDetailsForUI.getToDate(),
                    multipleDetailsForUI.getPostalCode(),
                    multipleDetailsForUI.getProvince()
            );
        }else if(multipleDetailsForUI.getFromDate()!=null || multipleDetailsForUI.getToDate()!=null) {
            detailsBasedOnMultipleDBResponse = repo.getDetailsBasedOnOneDate(multipleDetailsForUI.getFromDate(),
                    multipleDetailsForUI.getToDate(),
                    multipleDetailsForUI.getPostalCode(),
                    multipleDetailsForUI.getProvince()
            );
        }

        List<MultipleDetailsResponseDTO> responseDTO = detailsBasedOnMultipleDBResponse.stream().map(
                objArray->{
                    MultipleDetailsResponseDTO multipleResponse = new MultipleDetailsResponseDTO();
                multipleResponse.setRestaurantAddress((String)objArray[0]);
                multipleResponse.setRestaurantCategory((String)objArray[1]);
                multipleResponse.setRestaurantCity((String)objArray[2]);
                multipleResponse.setRestaurantCountry((String)objArray[3]);
                multipleResponse.setPublisherKey((String)objArray[4]);
                multipleResponse.setOwnerName((String)objArray[5]);
                return multipleResponse;
                }).collect(Collectors.toList());
        GlobalResponse<List<MultipleDetailsResponseDTO>> globalResponse = new GlobalResponse<>();
        globalResponse.setMessage("success");
        globalResponse.setData(responseDTO);
        globalResponse.setError(null);

        return globalResponse;
    }
}
