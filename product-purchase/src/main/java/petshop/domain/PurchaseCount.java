package petshop.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "PurchaseCount_table")
@Data
public class PurchaseCount {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long petId;

    private Long count;
}
