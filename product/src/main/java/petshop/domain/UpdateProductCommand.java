package petshop.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class UpdateProductCommand {

    private String name;
    private Money price;
    private String description;
}
