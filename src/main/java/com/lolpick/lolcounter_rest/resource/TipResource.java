package com.lolpick.lolcounter_rest.resource;

import java.util.List;
import java.util.stream.Collectors;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.lolpick.lolcounter_rest.dao.TipDao;
import com.lolpick.lolcounter_rest.entity.Tip;

@Path("tip")
public class TipResource {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllTips() throws Exception {
		List<Tip> tips = TipDao.readTips();
		
		List<JsonObject> jsons = tips.stream()
			.map(tip -> Json.createObjectBuilder()
					.add("id", tip.getId())
					.add("votes", tip.getVotes())
					.add("us", tip.getUs().getName())
					.add("tip", tip.getTip())
					.build())
			.collect(Collectors.toList());
		
		return Response.ok()
				.entity(jsons)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
}
