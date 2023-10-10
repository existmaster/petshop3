package petshop.external;

import java.util.Date;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-purchase", url = "${api.url.product-purchase}")
public interface PurchaseCountService {
    @GetMapping(path = "/purchaseCounts")
    public List<PurchaseCount> getPurchaseCount();

    @GetMapping(path = "/purchaseCounts/{id}")
    public PurchaseCount getPurchaseCount(@PathVariable("id") Long id);
}
