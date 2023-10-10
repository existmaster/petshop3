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
    collectionResourceRel = "petProfiles",
    path = "petProfiles"
)
public interface PetProfileRepository
    extends PagingAndSortingRepository<PetProfile, Long> {
    @Query(
        value = "select petProfile " +
        "from PetProfile petProfile " +
        "where(:id is null or petProfile.id like %:id%)"
    )
    List<PetProfile> findByGetProfile(String id, Pageable pageable);
}
