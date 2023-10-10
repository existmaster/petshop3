package petshop.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import petshop.domain.*;
import petshop.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ProductUpdated extends AbstractEvent {

    private String name;
    private Money price;
    private String description;

    public ProductUpdated(Product aggregate) {
        super(aggregate);
    }

    public ProductUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
