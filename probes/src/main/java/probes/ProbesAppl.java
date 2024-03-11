package probes;

import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import probes.service.ProbesService;
import telran.probes.dto.ProbeData;
@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class ProbesAppl {
	final ProbesService probesService;
	private static final long TIMEOUT = 1000;

	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext ctx = SpringApplication.run(ProbesAppl.class, args);
		Thread.sleep(TIMEOUT);
		ctx.close();
	}
	@Bean
	Supplier<ProbeData> probesSupplier() {
	return this::probeGeneration;
	}
	ProbeData probeGeneration() {
	return probesService.getProbeData();
	}
}
