package pl.namiekko.controllers;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;

import pl.namiekko.entities.Piece;

public interface PieceRepository extends CrudRepository<Piece, BigInteger>{

}
