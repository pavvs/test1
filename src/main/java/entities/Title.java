package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 12.05.13
 * Time: 12:33
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "titles")
public class Title {
    private int titleId;
    private String name;
    private String type;
//    private int publisherId;
    private Publisher publisher;
    private int pages;
    private double price;
    private int sales;
    private Date publishingDate;
    private byte contract;
    private List<Author> authorList = new ArrayList<Author>();
    private Royalty royalty;
//
    @OneToOne(mappedBy = "title",
            cascade = CascadeType.ALL)
    public Royalty getRoyalty() {
        return royalty;
    }

    public void setRoyalty(Royalty royalty) {
        this.royalty = royalty;
    }

    @ManyToMany
    @JoinTable(name = "title_authors", joinColumns = {@JoinColumn(name = "title_id")},
    inverseJoinColumns = {@JoinColumn(name = "au_id")})
    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    @ManyToOne
    @JoinColumn(name = "pub_id")
    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "title_id", nullable = false, unique = true)
    public int getTitleId() {
        return titleId;
    }

    public void setTitleId(int titleId) {
        this.titleId = titleId;
    }

    @Column(name = "title_name", nullable = false, length = 40)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(length = 10)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Column(precision = 2, scale = 5)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    @Column(name = "pubdate")
    @Temporal(TemporalType.DATE)
    public Date getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(Date publishingDate) {
        this.publishingDate = publishingDate;
    }

    public byte getContract() {
        return contract;
    }

    public void setContract(byte contract) {
        this.contract = contract;
    }
}
