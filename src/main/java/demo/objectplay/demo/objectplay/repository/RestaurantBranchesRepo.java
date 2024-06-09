package demo.objectplay.demo.objectplay.repository;

import demo.objectplay.demo.objectplay.entity.RestaurantBranches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface RestaurantBranchesRepo extends JpaRepository<RestaurantBranches, UUID> {

    @Query(value = "select \"rest-pincode\", \"rest-id\", \"rest-address\", \"rest-city\", " +
            "\"rest-keys\" from \"restaurant-details\" where \"rest-pincode\"=:restPincode", nativeQuery = true)
    List<Object[]> getRestaurantForPincode(String restPincode);

    @Query(value = "select address as RestaurantAddress, category as RestaurantCategory, city as RestaurantCity, " +
            "country as RestaurantCountry, keys as PublisherKey, name as OwnerName from \"restaurant-publishers\"" +
            "where " +
            "(:fromDate is null or \"date-added\" >= CAST(:fromDate as timestamp) AND :toDate is null or \"date-added\" <= CAST(:toDate as timestamp))"+
            "and (:postalCode is null or \"postal-code\" =:postalCode or :postalCode = '')" +
            "and (:province is null or \"province\" = :province or :province='')", nativeQuery = true)
    List<Object[]> getDetailsBasedOnMultipleParameters(String fromDate,
                                        String toDate,
                                        String postalCode,
                                        String province
    );


    @Query(value = "select address as RestaurantAddress, category as RestaurantCategory, city as RestaurantCity, " +
            "country as RestaurantCountry, keys as PublisherKey, name as OwnerName from \"restaurant-publishers\"" +
            "where " +
            "(:fromDate is null or \"date-added\" = CAST(:fromDate as timestamp) OR :toDate is null or \"date-added\" = CAST(:toDate as timestamp))"+
            "and (:postalCode is null or \"postal-code\" =:postalCode or :postalCode = '')" +
            "and (:province is null or \"province\" = :province or :province='')", nativeQuery = true)
    List<Object[]> getDetailsBasedOnOneDate(String fromDate,
                                                       String toDate,
                                                       String postalCode,
                                                       String province
    );

}
