package com.netcracker;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/calc")
public class CalculationRestService {

    @GET
    @Path("/add/{a}/{b}")
    @Produces(MediaType.TEXT_PLAIN)
    public String add(@PathParam("a") int a, @PathParam("b") int b){
            String out = a + "+" + b + "=" + (a+b);
        return out;
    }

    @GET
    @Path("/sub/{a}/{b}")
    @Produces(MediaType.TEXT_XML)
    public String sub(@PathParam("a") int a, @PathParam("b") int b){
        String out ="<result>" + a + "-" + b + "=" + (a-b) + "</result>";
        return out;
    }

    @GET
    @Path("/mul/{a}/{b}")
    @Produces(MediaType.TEXT_HTML)
    public String mul(@PathParam("a") int a, @PathParam("b") int b){
        String out ="<result>" + a + "*" + b + "=" + (a*b) + "</result>";
        return out;
    }

    @GET
    @Path("/div/{a}/{b}")
    @Produces(MediaType.TEXT_PLAIN)
    public String div(@PathParam("a") int a, @PathParam("b") int b){
        String out = a + "/" + b + "=" + (a/b);
        return out;
    }


}
