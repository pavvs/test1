package other;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 26.04.13
 * Time: 22:46
 * To change this template use File | Settings | File Templates.
 */
public class Other {

    public int divide(int a, int b) {
        if (b != 0) {
            return a/b;
        } else {
            throw new RuntimeException("b is 0!");
        }
    }
}
