package petshop.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import petshop.config.kafka.KafkaProcessor;
import petshop.domain.*;

@Service
public class PurchaseCountViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private PurchaseCountRepository purchaseCountRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPurchased_then_CREATE_1(@Payload Purchased purchased) {
        try {
            if (!purchased.validate()) return;

            // view 객체 생성
            PurchaseCount purchaseCount = new PurchaseCount();
            // view 객체에 이벤트의 Value 를 set 함
            purchaseCount.setPetId(Long.valueOf(purchased.getPetProfileId()));
            purchaseCount.setCount(purchaseCount.getCount() + 1);
            // view 레파지 토리에 save
            purchaseCountRepository.save(purchaseCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
