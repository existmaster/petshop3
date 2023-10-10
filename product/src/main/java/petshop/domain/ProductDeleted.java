package petshop.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import petshop.domain.*;
import petshop.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ProductDeleted extends AbstractEvent {

    private String id;

    public ProductDeleted(Product aggregate) {
        super(aggregate);
    }

    public ProductDeleted() {
        super();
    }
}
//>>> DDD / Domain Event
