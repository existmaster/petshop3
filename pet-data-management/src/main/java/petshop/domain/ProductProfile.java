package petshop.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import petshop.PetDataManagementApplication;

@Entity
@Table(name = "ProductProfile_table")
@Data
//<<< DDD / Aggregate Root
public class ProductProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ElementCollection
    private List<Ingredient> ingredients;

    public static ProductProfileRepository repository() {
        ProductProfileRepository productProfileRepository = PetDataManagementApplication.applicationContext.getBean(
            ProductProfileRepository.class
        );
        return productProfileRepository;
    }

    //<<< Clean Arch / Port Method
    public static void addProductProfile(ProductCreated productCreated) {
        //implement business logic here:

        /** Example 1:  new item 
        ProductProfile productProfile = new ProductProfile();
        repository().save(productProfile);

        */

        /** Example 2:  finding and process
        
        repository().findById(productCreated.get???()).ifPresent(productProfile->{
            
            productProfile // do something
            repository().save(productProfile);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
