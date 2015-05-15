package example.swagger.core;

import com.wordnik.swagger.jaxrs.config.BeanConfig;
import example.swagger.resources.FooResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("api")
public class DemoApplication extends Application {

    public DemoApplication() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes(new String[] {"http"});
        beanConfig.setHost("localhost:8002");
        beanConfig.setBasePath("swaggerapi");
        beanConfig.setResourcePackage("example.swagger.resources");
        beanConfig.setScan(true);
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet();
        resources.add(FooResource.class);
        //...
        resources.add(com.wordnik.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(com.wordnik.swagger.jaxrs.listing.SwaggerSerializers.class);
        return resources;
    }
}
