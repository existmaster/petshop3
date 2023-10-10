package petshop.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import petshop.ProductReviewApplication;

@Entity
@Table(name = "ProductReview_table")
@Data
//<<< DDD / Aggregate Root
public class ProductReview {

    @Id
    private String reviewId;

    private String productId;

    private Rating rating;

    private String comment;

    @PrePersist
    public void onPrePersist() {}

    public static ProductReviewRepository repository() {
        ProductReviewRepository productReviewRepository = ProductReviewApplication.applicationContext.getBean(
            ProductReviewRepository.class
        );
        return productReviewRepository;
    }

    //<<< Clean Arch / Port Method
    public void leaveReview(LeaveReviewCommand leaveReviewCommand) {
        //implement business logic here:

        ProductReviewLeft productReviewLeft = new ProductReviewLeft(this);
        productReviewLeft.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
