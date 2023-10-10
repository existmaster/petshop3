package petshop.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import petshop.PetDataManagementApplication;
import petshop.domain.PetProfileCreated;
import petshop.domain.ProfileChanged;

@Entity
@Table(name = "PetProfile_table")
@Data
//<<< DDD / Aggregate Root
public class PetProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int age;

    private String size;

    private String gender;

    private String preferences;

    private String needs;

    @ElementCollection
    private List<Allegy> allegies;

    private PetType petType;

    @PostPersist
    public void onPostPersist() {
        PetProfileCreated petProfileCreated = new PetProfileCreated(this);
        petProfileCreated.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    @PreUpdate
    public void onPreUpdate() {
        ProfileChanged profileChanged = new ProfileChanged(this);
        profileChanged.publishAfterCommit();
    }

    public static PetProfileRepository repository() {
        PetProfileRepository petProfileRepository = PetDataManagementApplication.applicationContext.getBean(
            PetProfileRepository.class
        );
        return petProfileRepository;
    }
}
//>>> DDD / Aggregate Root
