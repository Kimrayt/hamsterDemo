package com.example.eventdriven.mongodbRepository;
import com.example.eventdriven.models.Hamster;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHamsterRepository extends MongoRepository<Hamster, String> {
}