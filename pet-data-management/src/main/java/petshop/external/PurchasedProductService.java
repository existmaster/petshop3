package petshop.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "product-purchase", url = "${api.url.product-purchase}")
public interface PurchasedProductService {
    @RequestMapping(method = RequestMethod.POST, path = "/purchasedProducts")
    public void purchase(@RequestBody PurchasedProduct purchasedProduct);
}
