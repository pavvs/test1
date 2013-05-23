package annotations;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 20.05.13
 * Time: 9:53
 * To change this template use File | Settings | File Templates.
 */
public class AnnText {
    private  String text;

    public AnnText() {
    }

    public AnnText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "AnnText{" +
                "text='" + text + '\'' +
                '}';
    }
}
