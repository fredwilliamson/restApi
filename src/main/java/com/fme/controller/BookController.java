package com.fme.controller;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

import com.fme.bean.Author;
import com.fme.bean.Book;
import com.fme.bean.DetailBook;
import com.google.common.base.Strings;

@RestController
@RequestMapping("/services")
public class BookController {

    protected static final Book MONTE;
    protected static final Book ADIEU_ARMES;
    protected static final List<Book> ALL_BOOKS;

    static {
        ADIEU_ARMES = new DetailBook(new Book("L'Adieu aux armes", "22.3", new Author("Ernest", "Hemingway"), "1"),
                "Si l'on pouvait résumer le livre d'Hemingway, ce serait sur ces modestes dialogues qu'il faudrait méditer. Comment, en quelques lignes, son auteur met en place toute la trame de son roman qui raconte l'inéluctable basculement des êtres confrontés à leur destin, ironiquement, de la vie à l'amour et à la mort.",
                true, "10", "adieu_aux_armes.jpg");
        MONTE = new DetailBook(new Book("Le compte de Monte-Cristo", "33.5", new Author("Alexandre", "Dumas"), "2"),
                "On fit encore quatre ou cinq pas en montant toujours, puis Dantès sentit qu'on le prenait par la tête et par les pieds et qu'on le balançait.«Une, dirent les fossoyeurs.- Deux.- Trois !»En même temps, Dantès se sentit lancé, en effet, dans un vide énorme, traversant les airs comme un oiseau blessé, tombant, tombant toujours avec une épouvante qui lui glaçait le cœur. Quoique tiré en bas par quelque chose de pesant qui précipitait son vol rapide, il lui sembla que cette chute durait un siècle",
                true, "8", "monte-cristo.jpg");
        ALL_BOOKS = Arrays.asList(MONTE, ADIEU_ARMES);
    }

    @RequestMapping("/greeting")
    public Book greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return MONTE;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/books")
    public Collection<Book> getBooks() {
        return ALL_BOOKS;

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/book/id/{id}")
    public DetailBook getDetailBook(@PathVariable(value = "id") final String id) {
        if (Strings.isNullOrEmpty(id)) {
            throw new IllegalArgumentException("Le param id ne peut pas être null");
        }
        final List<Book> listById = ALL_BOOKS.stream().filter(book -> id.equals(book.getId()))
                .collect(Collectors.toList());
        return ((DetailBook) listById.stream().findFirst().orElse(null));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/books/author/{author}")
    public List<Book> getBooksByAuthor(@PathVariable(value = "author") final String author) {
        if (Strings.isNullOrEmpty(author)) {
            throw new IllegalArgumentException("Le param author ne peut pas être null");
        }
        return ALL_BOOKS.stream().filter(book -> book.getAuthor().getLastName().startsWith(author))
                .collect(Collectors.toList());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/author")
    public List<Author> getAuthorByName(@RequestParam(value = "name") final String name) {
        if (Strings.isNullOrEmpty(name)) {
            throw new IllegalArgumentException("Le param name ne peut pas être null");
        }
        return ALL_BOOKS.stream().filter(book -> book.getAuthor().getLastName().startsWith(name))
                .map(book -> book.getAuthor()).distinct().collect(Collectors.toList());
    }

}
