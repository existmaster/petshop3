package petshop.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import petshop.domain.*;

@Component
public class ProductProfileHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<ProductProfile>> {

    @Override
    public EntityModel<ProductProfile> process(
        EntityModel<ProductProfile> model
    ) {
        return model;
    }
}
