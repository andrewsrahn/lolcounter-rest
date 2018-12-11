package com.lolpick.lolcounter_rest.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("pick")
public class PickResource {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPick() throws Exception {
		return Response.ok()
				.build();
	}
}
