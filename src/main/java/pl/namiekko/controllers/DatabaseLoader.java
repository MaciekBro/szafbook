package pl.namiekko.controllers;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import pl.namiekko.entities.User;

@Service
@Profile("development")
public class DatabaseLoader {
	private final PieceRepository pieceRepository;
	private final SizeRepository sizeRepository;
	private final UserRepository userRepository;
	private final WardrobeRepository wardrobeRepository;

	@Autowired
	public DatabaseLoader(PieceRepository pieceRepository, SizeRepository sizeRepository, UserRepository userRepository,
			WardrobeRepository wardrobeRepository) {
		this.pieceRepository = pieceRepository;
		this.sizeRepository = sizeRepository;
		this.userRepository = userRepository;
		this.wardrobeRepository = wardrobeRepository;
	}

	@PostConstruct
	private void initDatabase() {
		pieceRepository.deleteAll();
		sizeRepository.deleteAll();
		userRepository.deleteAll();
		wardrobeRepository.deleteAll();

//		User user = new User();
//		user.setEmail("user@example.com");
//		user.setDisplayedName("First User <3");
//		user.setUserName("first1");
//		userRepository.save(user);
	}
}
