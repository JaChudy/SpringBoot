package pl.chudyja.com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.chudyja.com.demo.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
