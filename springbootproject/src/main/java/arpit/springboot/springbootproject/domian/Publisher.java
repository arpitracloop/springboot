package arpit.springboot.springbootproject.domian;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Publisher
{
   @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long Id;

    private String name;
    private String addrssLine1;
    private String city;
    private String state;
    private int zip;

    @OneToMany
    @JoinColumn(name = "publisher_id")
    private Set<Book> books = new HashSet<>();

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Publisher(String name, String addrssLine1, String city, String state, int zip)
    {
        this.name = name;
        this.addrssLine1 = addrssLine1;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public Publisher() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddrssLine1() {
        return addrssLine1;
    }

    public void setAddrssLine1(String addrssLine1) {
        this.addrssLine1 = addrssLine1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        return Id != null ? Id.equals(publisher.Id) : publisher.Id == null;
    }

    @Override
    public int hashCode() {
        return Id != null ? Id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", addrssLine1='" + addrssLine1 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                '}';
    }

}
