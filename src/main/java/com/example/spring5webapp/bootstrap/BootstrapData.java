package com.example.spring5webapp.bootstrap;

import com.example.spring5webapp.domain.Author;
import com.example.spring5webapp.domain.Book;
import com.example.spring5webapp.domain.Publisher;
import com.example.spring5webapp.repository.AuthorRepository;
import com.example.spring5webapp.repository.BookRepository;
import com.example.spring5webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(
            AuthorRepository authorRepository,
            BookRepository bookRepository,
            PublisherRepository publisherRepository
    ) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher pub = new Publisher(
                "Best paying publisher ever",
                "101 Dummie Str",
                "City of Angels",
                "Midlothian",
                "ABC1234"
        );
        publisherRepository.save(pub);
        Author mau = new Author("Mauricio", "Lacerda");
        Book gtpc = new Book("Guide to polymer clay", "123123123", pub);
        mau.getBooks().add(gtpc);
        gtpc.getAuthors().add(mau);
        pub.getBooks().add(gtpc);

        authorRepository.save(mau);
        bookRepository.save(gtpc);
        publisherRepository.save(pub);

        Author rafa = new Author("Rafael", "Fernandes");
        Book bccfc = new Book("Best cheesecake factory copycats", "321123321", pub);
        rafa.getBooks().add(bccfc);
        bccfc.getAuthors().add(rafa);
        pub.getBooks().add(bccfc);

        authorRepository.save(rafa);
        bookRepository.save(bccfc);
        publisherRepository.save(pub);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books saved = " + bookRepository.count());
        System.out.println("Number of books saved = " + bookRepository.findAll());

    }
}
