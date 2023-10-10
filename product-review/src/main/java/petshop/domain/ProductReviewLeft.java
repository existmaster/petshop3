package petshop.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import petshop.domain.*;
import petshop.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ProductReviewLeft extends AbstractEvent {

    private String reviewId;
    private String productId;
    private Rating rating;
    private String comment;

    public ProductReviewLeft(ProductReview aggregate) {
        super(aggregate);
    }

    public ProductReviewLeft() {
        super();
    }
}
//>>> DDD / Domain Event
