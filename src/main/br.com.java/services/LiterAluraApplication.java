package services;

import main.Main;
import repositories.AuthorRepository;
import repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;

	@Autowired
	public LiterAluraApplication(AuthorRepository authorRepository, BookRepository bookRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) {
		try {
			Main main = new Main(authorRepository, bookRepository);
			main.principal();
		} catch (Exception e) {
			// Registra a exceção para depuração
			e.printStackTrace();
			// Ou você pode usar um logger para registrar a exceção
			// Logger logger = LoggerFactory.getLogger(LiterAluraApplication.class);
			// logger.error("Erro durante a inicialização", e);
		}
	}
}
