package probes.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import probes.repo.RangeRepo;
import telran.probes.dto.*;
@Service
@Slf4j
@RequiredArgsConstructor
public class ProbesServiceImpl implements ProbesService{
final RangeRepo rangRepo;
private  int MIN_VALUE = 100000;
private int MAX_VALUE = 999999;
private double PROBABILITY = 0.2;
	@Override
	public ProbeData getProbeData() {
		List<SensorRange> rages = rangRepo.findAll();
		HashMap<Long, Range> rangesMap = (HashMap<Long, Range>) rages.stream().collect(Collectors.toMap(SensorRange::id, SensorRange::range));
		Long id = getRandomSensorId();
		Range range = getRandomRangeFromMap(rangesMap);
		Long timestamp = System.currentTimeMillis();
		Double value = getRandomValue( range);
		log.debug("probeData with id {} and value", id, value);
		return new ProbeData(id, value, timestamp);
	}
	private Double getRandomValue(Range range) {
		Random random = new Random();
		if (random.nextDouble() < PROBABILITY) {
			if(random.nextBoolean()) {
				return random.nextDouble() * (range.minValue() - Double.MIN_VALUE);
			}else {
				return random.nextDouble() * (Double.MAX_VALUE - range.maxValue());
			}
			}else {
				return range.minValue() + random.nextDouble() * (range.maxValue() - range.minValue());
			
		}
		
	}
	private Range getRandomRangeFromMap(HashMap<Long, Range> rangesMap) {
		List<Long> ranges = rangesMap.keySet().stream().map(key -> key).toList();
		long id = ranges.get(new Random().nextInt(ranges.size()));
		
		return rangesMap.get(id);
	}
	private Long getRandomSensorId() {
		return ThreadLocalRandom.current().nextLong(MIN_VALUE, MAX_VALUE + 1);
	}

}
