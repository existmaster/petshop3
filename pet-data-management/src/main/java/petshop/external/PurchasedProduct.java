package petshop.external;

import java.util.Date;
import lombok.Data;

@Data
public class PurchasedProduct {

    private String productId;
    private String productName;
    private Object price;
    private Object petProfileId;
}
