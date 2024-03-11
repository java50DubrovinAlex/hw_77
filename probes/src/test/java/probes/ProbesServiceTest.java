package probes;

import static org.junit.jupiter.api.Assertions.*;
import telran.probes.dto.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import probes.repo.RangeRepo;
import probes.service.ProbesService;
@SpringBootTest
class ProbesServiceTest {
	@Autowired
	ProbesService probesService;
	@Autowired
	RangeRepo rangeRepo;
	
	private static final long SENSORID_1 = 123;
	private static final long SENSORID_2 = 124;
	private static final long SENSORID_3 = 125;
	private static final double MIN_VALUE_1 = 100;
	private static final double MIN_VALUE_2 = 200;
	private static final double MIN_VALUE_3 = 300;
	private static final double MAX_VALUE_1 = 150;
	private static final double MAX_VALUE_2 = 250;
	private static final double MAX_VALUE_3 = 350;

	SensorRange sensorRange1 = new SensorRange(SENSORID_1, new Range(MIN_VALUE_1, MAX_VALUE_1));
	SensorRange sensorRange2 = new SensorRange(SENSORID_2, new Range(MIN_VALUE_2, MAX_VALUE_2));
	SensorRange sensorRange3 = new SensorRange(SENSORID_3, new Range(MIN_VALUE_3, MAX_VALUE_3));

	@BeforeEach
	void setUp() throws Exception {
		rangeRepo.save(sensorRange1);
		rangeRepo.save(sensorRange2);
		rangeRepo.save(sensorRange3);
	}

	@Test
	void test() {
		probesService.getProbeData();
	}

}
