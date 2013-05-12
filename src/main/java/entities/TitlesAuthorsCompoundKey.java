package entities;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 12.05.13
 * Time: 18:07
 * To change this template use File | Settings | File Templates.
 */
@Embeddable
public class TitlesAuthorsCompoundKey implements Serializable {
    private int au_id;
    private int title_id;

    public int getAu_id() {
        return au_id;
    }

    public void setAu_id(int au_id) {
        this.au_id = au_id;
    }

    public int getTitle_id() {
        return title_id;
    }

    public void setTitle_id(int title_id) {
        this.title_id = title_id;
    }
}
