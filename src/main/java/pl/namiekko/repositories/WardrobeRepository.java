package pl.namiekko.repositories;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;

import pl.namiekko.entities.Wardrobe;

public interface WardrobeRepository extends CrudRepository<Wardrobe, BigInteger>{

}
