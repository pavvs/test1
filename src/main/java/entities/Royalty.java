package entities;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 12.05.13
 * Time: 20:56
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "royalties")
public class Royalty {
    private double advance;
    private double royalty_rate;
    private Title title;
    private int royalty_id;

    @Id
    @Column(name = "title_id")
    public int getRoyalty_id() {
        return royalty_id;
    }

    public void setRoyalty_id(int royalty_id) {
        this.royalty_id = royalty_id;
    }
//     @Id
    @OneToOne(
            cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "title_id")
    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public double getAdvance() {
        return advance;
    }

    public void setAdvance(double advance) {
        this.advance = advance;
    }

    public double getRoyalty_rate() {
        return royalty_rate;
    }

    public void setRoyalty_rate(double royaltyRate) {
        this.royalty_rate = royaltyRate;
    }

 }
