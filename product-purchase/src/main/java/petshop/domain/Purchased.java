package petshop.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import petshop.domain.*;
import petshop.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Purchased extends AbstractEvent {

    private String productId;
    private String productName;
    private Money price;
    private PetProfileId petProfileId;

    public Purchased(PurchasedProduct aggregate) {
        super(aggregate);
    }

    public Purchased() {
        super();
    }
}
//>>> DDD / Domain Event
