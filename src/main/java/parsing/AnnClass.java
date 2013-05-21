package parsing;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 20.05.13
 * Time: 23:09
 * To change this template use File | Settings | File Templates.
 */
public class AnnClass {
    @FieldValue(value = "5")
    private int count ;
    @FieldValue(value = "15")
    private long loncount;
    @FieldValue(value = "d")
    private char lit;
    @FieldValue(value = "true")
    private boolean thing;
    @FieldValue(value = "something")
    private   String text;

    public AnnClass() {
    }

    public AnnClass(int count, long loncount, char lit, boolean thing, String text) {
        this.count = count;
        this.loncount = loncount;
        this.lit = lit;
        this.thing = thing;
        this.text = text;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public long getLoncount() {
        return loncount;
    }

    public void setLoncount(long loncount) {
        this.loncount = loncount;
    }

    public char getLit() {
        return lit;
    }

    public void setLit(char lit) {
        this.lit = lit;
    }

    public boolean isThing() {
        return thing;
    }

    public void setThing(boolean thing) {
        this.thing = thing;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "AnnClass{" +
                "count=" + count +
                ", loncount=" + loncount +
                ", lit=" + lit +
                ", thing=" + thing +
                ", text='" + text + '\'' +
                '}';
    }
}
