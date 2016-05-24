package pl.namiekko.repositories;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;

import pl.namiekko.entities.Size;

public interface SizeRepository extends CrudRepository<Size, BigInteger>{

}
