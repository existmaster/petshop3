package petshop.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import petshop.domain.*;

@RepositoryRestResource(
    collectionResourceRel = "purchaseCounts",
    path = "purchaseCounts"
)
public interface PurchaseCountRepository
    extends PagingAndSortingRepository<PurchaseCount, Long> {}
