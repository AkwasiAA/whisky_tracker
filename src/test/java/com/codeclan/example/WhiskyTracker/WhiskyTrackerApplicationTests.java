package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Id;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindWhiskyByYear(){
		List<Whisky> whiskiesFound = whiskyRepository.findByYear(2018);
		assertEquals(6, whiskiesFound.size());
	}

	@Test
	public void canFindDistilleryByRegion(){
		List<Distillery> distilleryFound = distilleryRepository.findDistilleryByRegion("Speyside");
		assertEquals("Speyside", distilleryFound.get(2).getRegion());
	}

	@Test
	public void canFindWhiskyByDistilleryAndAge(){
		List<Whisky> foundWhiskies = whiskyRepository.findWhiskyByDistilleryIdAndAge(2L, 12);
		assertEquals(1, foundWhiskies.size());
	}



}
