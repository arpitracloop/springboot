package arpit.springboot.springbootproject.bootstrap;

import arpit.springboot.springbootproject.domian.Author;
import arpit.springboot.springbootproject.domian.Book;
import arpit.springboot.springbootproject.domian.Publisher;
import arpit.springboot.springbootproject.repositories.AuthorRepository;
import arpit.springboot.springbootproject.repositories.BookRepository;
import arpit.springboot.springbootproject.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner
{
    @Autowired
    public  AuthorRepository authorRepository;
    @Autowired
    public  BookRepository bookRepository;
    @Autowired
    public  PublisherRepository publisherRepository;


 //   public PublisherRepository getPublisherRepository() {
   //     return publisherRepository;

    //
//    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
//        this.authorRepository = authorRepository;
//        this.bookRepository = bookRepository;
//    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design","123123");
        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("Zirakpur");
        publisher.setState("Punjab");
        publisher.setZip(890890);

        //publisherRepository.save();


        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);


        bookRepository.save(ddd);
        authorRepository.save(eric);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod","Johnson");
        Book noEJB =new Book("J2EE Development without EJB","456456");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books : "+ bookRepository.count());
        System.out.println("Number of authors : "+authorRepository.count());
        System.out.println("Number of publishers :" +publisherRepository.count());
        System.out.println("Publisher Name: "+publisher.getName());
        System.out.println("Publisher address: "+ publisher.getAddrssLine1());
        System.out.println("Publisher city: "+ publisher.getCity());
        System.out.println("Publisher state: "+ publisher.getState());
        System.out.println("Publisher zip: "+ publisher.getZip());


    }
}
