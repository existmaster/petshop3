package petshop.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CreateProductCommand {

    private String name;
    private Money price;
    private String description;
}
