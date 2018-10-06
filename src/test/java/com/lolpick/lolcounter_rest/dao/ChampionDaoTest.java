package com.lolpick.lolcounter_rest.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.lolpick.lolcounter_rest.entity.Champion;

public class ChampionDaoTest {

	@Test
	public void testGetChampions() {
		List<Champion> champions = ChampionDao.readChampions();
		assertEquals(140, champions.size());
		assertEquals("Aatrox", champions.get(0).getName());
	}

}
