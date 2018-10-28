package com.lolpick.lolcounter_rest.resource;

import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.lolpick.lolcounter_rest.dao.ChampionDao;
import com.lolpick.lolcounter_rest.entity.Champion;

@Path("champion")
public class ChampionResource {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllChampions() throws Exception {
		List<JsonObject> jsons = new ArrayList<>();
		
		for(Champion champion: ChampionDao.readChampions()) {
			
			JsonArrayBuilder lanes = Json.createArrayBuilder();
			JsonArrayBuilder roles = Json.createArrayBuilder();
			
			champion.getLanes().stream()
				.forEach(lane -> lanes.add(lane.getLane()));
			
			champion.getRoles().stream()
				.forEach(role -> roles.add(role.getRole()));
			
			
			JsonObject json = Json.createObjectBuilder()
					.add("id", champion.getId())
					.add("name", champion.getName())
					.add("lanes", lanes.build())
					.add("roles", roles)
					.build();
			
			jsons.add(json);
		}
		
		return Response.ok()
				.entity(jsons)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
}