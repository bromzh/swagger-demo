package example.swagger.resources;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import example.swagger.entities.Foo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.LinkedList;
import java.util.List;

@Path("/foo")
@Api(value="/foo", description="Foo")
@Produces(MediaType.APPLICATION_JSON)
public class FooResource {
    @GET
    @ApiOperation(value = "List shops", httpMethod = "GET",
            notes = "List nearest or locality shops",
            response = Foo.class, responseContainer = "List")
    public List<Foo> getAll(
            @ApiParam(value = "Bar", required = false)
            @QueryParam("bar") String bar) {
        List<Foo> result = new LinkedList<>();

        Foo foo1 = new Foo();
        foo1.setName("Foo 1");
        foo1.setValue(1);

        Foo foo2 = new Foo();
        foo2.setName("Foo 2");
        foo2.setValue(2);

        result.add(foo1);
        result.add(foo2);
        return result;
    }
}
