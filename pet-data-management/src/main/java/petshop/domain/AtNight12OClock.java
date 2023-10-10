package petshop.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import petshop.domain.*;
import petshop.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class AtNight12OClock extends AbstractEvent {

    private Long id;

    public AtNight12OClock() {
        super();
    }
}
//>>> DDD / Domain Event
