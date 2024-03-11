package probes.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import telran.probes.dto.SensorRange;

public interface RangeRepo extends MongoRepository<SensorRange, Long>{

}
