package petshop.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import petshop.domain.*;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/productReviews")
@Transactional
public class ProductReviewController {

    @Autowired
    ProductReviewRepository productReviewRepository;

    @RequestMapping(
        value = "productReviews/",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public ProductReview leaveReview(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody ProductReview productReview
    ) throws Exception {
        System.out.println("##### /productReview/leaveReview  called #####");
        productReview.leaveReview(leaveReviewcommand);
        productReviewRepository.save(productReview);
        return productReview;
    }
}
//>>> Clean Arch / Inbound Adaptor
