package petshop.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import petshop.domain.*;
import petshop.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ProductCreated extends AbstractEvent {

    private String name;
    private String description;
    private List<Ingredient> ingredients;
    private Money price;

    public ProductCreated(Product aggregate) {
        super(aggregate);
    }

    public ProductCreated() {
        super();
    }
}
//>>> DDD / Domain Event
