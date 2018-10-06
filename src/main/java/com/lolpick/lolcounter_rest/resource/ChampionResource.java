package com.lolpick.lolcounter_rest.resource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.lolpick.lolcounter_rest.dao.ChampionDao;
import com.lolpick.lolcounter_rest.entity.Champion;
import com.lolpick.lolcounter_rest.entity.Lane;
import com.lolpick.lolcounter_rest.entity.Role;

@Path("champion")
public class ChampionResource {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllChampions() throws Exception {
		List<Champion> champions = ChampionDao.readChampions();
		System.out.println(new Champion(1, "Andrew"));
		System.out.println(champions.get(0));
		
		Champion champion = champions.get(0);
		
		return Response.ok()
				.entity(champion)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
}