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

import com.lolpick.lolcounter_rest.dao.ChampionDao;
import com.lolpick.lolcounter_rest.entity.Champion;

@Path("champion")
public class ChampionResource {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllChampions() throws Exception {
		List<Champion> champions = ChampionDao.readChampions();
		
		List<JsonObject> jsons = ChampionDao.readChampions().stream()
				.map(champion -> Json.createObjectBuilder()
						.add("id", champion.getId())
						.add("name", champion.getName())
						.add("lanes", champion.getLanes().toString())
						.add("roles", champion.getRoles().toString())
						.build())
				.collect(Collectors.toList());
		
		return Response.ok()
				.entity(jsons)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
}