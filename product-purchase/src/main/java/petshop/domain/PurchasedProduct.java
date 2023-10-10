package petshop.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import petshop.ProductPurchaseApplication;
import petshop.domain.Purchased;

@Entity
@Table(name = "PurchasedProduct_table")
@Data
//<<< DDD / Aggregate Root
public class PurchasedProduct {

    @Id
    private String productId;

    private String productName;

    @Embedded
    private Money price;

    @Embedded
    private PetProfileId petProfileId;

    @PostPersist
    public void onPostPersist() {
        Purchased purchased = new Purchased(this);
        purchased.publishAfterCommit();
    }

    public static PurchasedProductRepository repository() {
        PurchasedProductRepository purchasedProductRepository = ProductPurchaseApplication.applicationContext.getBean(
            PurchasedProductRepository.class
        );
        return purchasedProductRepository;
    }
}
//>>> DDD / Aggregate Root
