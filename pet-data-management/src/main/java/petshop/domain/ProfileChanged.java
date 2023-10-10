package petshop.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import petshop.domain.*;
import petshop.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ProfileChanged extends AbstractEvent {

    private Long id;
    private int age;
    private String size;
    private String gender;
    private String preferences;
    private String needs;
    private List<Allegy> allegies;
    private PetType petType;

    public ProfileChanged(PetProfile aggregate) {
        super(aggregate);
    }

    public ProfileChanged() {
        super();
    }
}
//>>> DDD / Domain Event
