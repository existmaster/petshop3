package petshop.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import petshop.PetDataManagementApplication;

@Entity
@Table(name = "RecommendedProduct_table")
@Data
//<<< DDD / Aggregate Root
public class RecommendedProduct {

    @Id
    private String productType;

    private String size;

    private int age;

    private String gender;

    private String preferences;

    @Embedded
    private Photo photo;

    @Embedded
    private PetProfileId petProfileId;

    public static RecommendedProductRepository repository() {
        RecommendedProductRepository recommendedProductRepository = PetDataManagementApplication.applicationContext.getBean(
            RecommendedProductRepository.class
        );
        return recommendedProductRepository;
    }

    //<<< Clean Arch / Port Method
    public static void recommend(AtNight12OClock atNight12OClock) {
        //implement business logic here:

        /** Example 1:  new item 
        RecommendedProduct recommendedProduct = new RecommendedProduct();
        repository().save(recommendedProduct);

        */

        /** Example 2:  finding and process
        
        repository().findById(atNight12OClock.get???()).ifPresent(recommendedProduct->{
            
            recommendedProduct // do something
            repository().save(recommendedProduct);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void recommend(PetProfileCreated petProfileCreated) {
        //implement business logic here:

        /** Example 1:  new item 
        RecommendedProduct recommendedProduct = new RecommendedProduct();
        repository().save(recommendedProduct);

        */

        /** Example 2:  finding and process
        
        repository().findById(petProfileCreated.get???()).ifPresent(recommendedProduct->{
            
            recommendedProduct // do something
            repository().save(recommendedProduct);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void recommend(ProfileChanged profileChanged) {
        //implement business logic here:

        /** Example 1:  new item 
        RecommendedProduct recommendedProduct = new RecommendedProduct();
        repository().save(recommendedProduct);

        */

        /** Example 2:  finding and process
        
        repository().findById(profileChanged.get???()).ifPresent(recommendedProduct->{
            
            recommendedProduct // do something
            repository().save(recommendedProduct);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void recommend(ProductCreated productCreated) {
        //implement business logic here:

        /** Example 1:  new item 
        RecommendedProduct recommendedProduct = new RecommendedProduct();
        repository().save(recommendedProduct);

        */

        /** Example 2:  finding and process
        
        repository().findById(productCreated.get???()).ifPresent(recommendedProduct->{
            
            recommendedProduct // do something
            repository().save(recommendedProduct);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
