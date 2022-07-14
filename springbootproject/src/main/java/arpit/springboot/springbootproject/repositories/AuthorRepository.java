package arpit.springboot.springbootproject.repositories;

import arpit.springboot.springbootproject.domian.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long>
{

}
