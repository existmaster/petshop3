package petshop.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import petshop.config.kafka.KafkaProcessor;
import petshop.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    PetProfileRepository petProfileRepository;

    @Autowired
    RecommendedProductRepository recommendedProductRepository;

    @Autowired
    ProductProfileRepository productProfileRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='AtNight12OClock'"
    )
    public void wheneverAtNight12OClock_Recommend(
        @Payload AtNight12OClock atNight12OClock
    ) {
        AtNight12OClock event = atNight12OClock;
        System.out.println(
            "\n\n##### listener Recommend : " + atNight12OClock + "\n\n"
        );

        // REST Request Sample

        // getProfileService.getGetProfile(/** mapping value needed */);

        // Sample Logic //
        RecommendedProduct.recommend(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PetProfileCreated'"
    )
    public void wheneverPetProfileCreated_Recommend(
        @Payload PetProfileCreated petProfileCreated
    ) {
        PetProfileCreated event = petProfileCreated;
        System.out.println(
            "\n\n##### listener Recommend : " + petProfileCreated + "\n\n"
        );

        // REST Request Sample

        // getProfileService.getGetProfile(/** mapping value needed */);

        // Sample Logic //
        RecommendedProduct.recommend(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ProfileChanged'"
    )
    public void wheneverProfileChanged_Recommend(
        @Payload ProfileChanged profileChanged
    ) {
        ProfileChanged event = profileChanged;
        System.out.println(
            "\n\n##### listener Recommend : " + profileChanged + "\n\n"
        );

        // REST Request Sample

        // getProfileService.getGetProfile(/** mapping value needed */);

        // Sample Logic //
        RecommendedProduct.recommend(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ProductCreated'"
    )
    public void wheneverProductCreated_Recommend(
        @Payload ProductCreated productCreated
    ) {
        ProductCreated event = productCreated;
        System.out.println(
            "\n\n##### listener Recommend : " + productCreated + "\n\n"
        );

        // REST Request Sample

        // getProfileService.getGetProfile(/** mapping value needed */);

        // Sample Logic //
        RecommendedProduct.recommend(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ProductCreated'"
    )
    public void wheneverProductCreated_AddProductProfile(
        @Payload ProductCreated productCreated
    ) {
        ProductCreated event = productCreated;
        System.out.println(
            "\n\n##### listener AddProductProfile : " + productCreated + "\n\n"
        );

        // REST Request Sample

        // purchaseCountService.getPurchaseCount(/** mapping value needed */);

        // Sample Logic //
        ProductProfile.addProductProfile(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
