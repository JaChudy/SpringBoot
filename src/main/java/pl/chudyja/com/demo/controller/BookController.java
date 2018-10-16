package pl.chudyja.com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.chudyja.com.demo.model.Book;
import pl.chudyja.com.demo.repository.BookRepository;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("books")
    public List<Book> getBooks(){
        return  bookRepository.findAll();
    }

    @PostMapping("books")
    public Book addBook(@RequestBody Book book){ //@RequestBody pozwala na zmapowanie obiektu w formacie JONSON
        //do obiektu Javy na podstawie klucza i wartości
        return bookRepository.save(book);
     }

}


//@CrossOrigin, to adnotacja pozwalająca na dostęp do serwisu
// z poziomu lokalnej przeglądarki na lokalny serwer.
// Docelowo będziemy uruchamiać dwa lokalne serwery.
// Jeden na porcie 8080 dla naszego kontenera servletów, czyli Tomcata,
// drugi to serwer Node dla aplikacji Angular na porcie 4200.

//@RestController, to adnotacja Springowa.
// Podczas uruchamiania aplikacji Spring skanuje klasy projektu i szuka oznaczeń, które wskazują,
// że jest to komponent aplikacji. Aby skorzystać z mechanizmu zarządzania zależnościami przez kontener
// Spring należy wskazać taką klasę poprzez jej oznaczenie adnotacją.