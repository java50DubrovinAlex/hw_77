package probes.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import probes.model.SensorRangeDoc;

public interface RangeRepo extends MongoRepository<SensorRangeDoc, Long>{

}
