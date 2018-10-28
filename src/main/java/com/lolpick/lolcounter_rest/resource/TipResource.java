package com.lolpick.lolcounter_rest.resource;

import java.util.List;
import java.util.stream.Collectors;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.lolpick.lolcounter_rest.dao.TipDao;
import com.lolpick.lolcounter_rest.entity.Tip;

@Path("tip")
public class TipResource {
	@Path("all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllTips() throws Exception {
		List<JsonObject> jsons = TipDao.readTips().stream()
			.map(tip -> Json.createObjectBuilder()
					.add("votes", tip.getVotes())
					.add("us", tip.getUs().getName())
					.add("them", tip.getThem())
					.add("tip", tip.getTip())
					.build())
			.collect(Collectors.toList());
		
		return Response.ok()
				.entity(jsons)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@Path("query")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTipsForChampionQuery(@QueryParam("name") String name) throws Exception {
		List<Tip> tips = TipDao.readTips().stream()
				.filter(tip -> tip.getUs().getName().equals(name))
				.collect(Collectors.toList());
		
		List<JsonObject> jsons = tips.stream()
				.map(tip -> Json.createObjectBuilder()
						.add("votes", tip.getVotes())
						.add("us", tip.getUs().getName())
						.add("them", tip.getThem())
						.add("tip", tip.getTip())
						.build())
				.collect(Collectors.toList());
		
		return Response.ok()
				.entity(jsons)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@Path("form")
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTipsForChampionForm(@FormParam("name") String name) throws Exception {
		List<Tip> tips = TipDao.readTips().stream()
				.filter(tip -> tip.getUs().getName().equals(name))
				.collect(Collectors.toList());
		
		List<JsonObject> jsons = tips.stream()
				.map(tip -> Json.createObjectBuilder()
						.add("votes", tip.getVotes())
						.add("us", tip.getUs().getName())
						.add("them", tip.getThem())
						.add("tip", tip.getTip())
						.build())
				.collect(Collectors.toList());
		
		return Response.ok()
				.entity(jsons)
				.type(MediaType.APPLICATION_JSON)
				.build();		
		
	}

}
