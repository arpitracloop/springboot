package arpit.springboot.springbootproject.repositories;

import arpit.springboot.springbootproject.domian.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>
{

}
