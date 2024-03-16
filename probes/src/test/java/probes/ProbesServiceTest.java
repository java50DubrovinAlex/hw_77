package probes;

import static org.junit.jupiter.api.Assertions.*;
import telran.probes.dto.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.binder.test.OutputDestination;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.context.annotation.Import;

import probes.repo.RangeRepo;
import probes.service.ProbesService;
@SpringBootTest
@Import(TestChannelBinderConfiguration.class)
public class ProbesServiceTest {
	
	@Autowired
	OutputDestination consumer;
	@Test
	void test() throws InterruptedException {
		String bindingName = "probesSupplier-out-0";
		for (int i = 0; i < 8; i++) {
			assertNotNull(consumer.receive(1500, bindingName));
		}
		
	}
	
}