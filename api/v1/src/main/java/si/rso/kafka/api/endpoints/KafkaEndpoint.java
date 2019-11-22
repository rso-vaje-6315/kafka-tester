package si.rso.kafka.api.endpoints;

import si.rso.kafka.services.KafkaService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/kafka")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class KafkaEndpoint {
    
    @Inject
    private KafkaService kafkaService;
    
    @POST
    @Path("/produce/{topic}")
    public Response produceKafkaMessage(@PathParam("topic") String topic, Object message) {
        kafkaService.produceMessage(topic, message);
        return Response.ok().build();
    }

}
