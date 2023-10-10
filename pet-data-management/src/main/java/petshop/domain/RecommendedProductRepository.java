package petshop.domain;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import petshop.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "recommendedProducts",
    path = "recommendedProducts"
)
public interface RecommendedProductRepository
    extends PagingAndSortingRepository<RecommendedProduct, String> {
    @Query(
        value = "select recommendedProduct " +
        "from RecommendedProduct recommendedProduct " +
        "where(:petProfileId is null or recommendedProduct.petProfileId like %:petProfileId%)"
    )
    List<RecommendedProduct> findByRecommendationByPetId(
        String petProfileId,
        Pageable pageable
    );
}
