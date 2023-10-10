package petshop.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class LeaveReviewCommand {

    private String reviewId;
    private String productId;
    private Rating rating;
    private String comment;
}
