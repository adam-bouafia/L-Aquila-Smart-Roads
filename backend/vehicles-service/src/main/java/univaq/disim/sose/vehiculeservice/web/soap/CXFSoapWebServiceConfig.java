package univaq.disim.sose.vehiculeservice.web.soap;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for setting up the CXF SOAP Web Service.
 */
@Configuration
public class CXFSoapWebServiceConfig {

    @Autowired
    private Bus bus; // Injected CXF Bus object, which manages the lifecycle of CXF services and endpoints.

    @Autowired
    private OwnerSoapService ownerSoapService; // Injected service implementation to be exposed as a SOAP web service.

    /**
     * Creates and publishes a CXF endpoint for the OwnerSoapService.
     * 
     * @return Configured EndpointImpl object that publishes the SOAP service.
     */
    @Bean
    public EndpointImpl endpoint() {
        // Create a new endpoint with the CXF Bus and the service implementation.
        EndpointImpl endpoint = new EndpointImpl(bus, ownerSoapService);
        
        // Publish the endpoint at the specified URL path.
        endpoint.publish("/owService");

        // Return the configured endpoint.
        return endpoint;
    }
}
