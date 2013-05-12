package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 12.05.13
 * Time: 17:58
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "title_authors")
public class TitlesAuthors {
    private int authorOrder;
    private double royaltyShare;
    private TitlesAuthorsCompoundKey titlesAuthorsCompoundKey;

    @Id
    public TitlesAuthorsCompoundKey getTitlesAuthorsCompoundKey() {
        return titlesAuthorsCompoundKey;
    }

    public void setTitlesAuthorsCompoundKey(TitlesAuthorsCompoundKey titlesAuthorsCompoundKey) {
        this.titlesAuthorsCompoundKey = titlesAuthorsCompoundKey;
    }

    public int getAuthorOrder() {
        return authorOrder;
    }

    public void setAuthorOrder(int authorOrder) {
        this.authorOrder = authorOrder;
    }

    public double getRoyaltyShare() {
        return royaltyShare;
    }

    public void setRoyaltyShare(double royaltyShare) {
        this.royaltyShare = royaltyShare;
    }
}
