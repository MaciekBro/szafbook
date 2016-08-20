package pl.namiekko.services;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import pl.namiekko.entities.User;
import pl.namiekko.repositories.PieceRepository;
import pl.namiekko.repositories.SizeRepository;
import pl.namiekko.repositories.UserRepository;
import pl.namiekko.repositories.WardrobeRepository;

@Service
@Profile("unused")
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
//		pieceRepository.deleteAll();
//		sizeRepository.deleteAll();
//		userRepository.deleteAll();
//		wardrobeRepository.deleteAll();

//		User user = new User();
//		user.setEmail("user@example.com");
//		user.setDisplayedName("First User <3");
//		user.setUsername("first1");
//		user.setPassword1("abcdef");
//		user.setConfirmationStatus(true);
//		userRepository.save(user);
	}
}
