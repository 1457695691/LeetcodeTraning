package test.unsafe;

/**
 * @author Ayuan
 * @Description: TODO
 * @date 2023/4/21 17:56
 */
public class Guard {
    private int ACCESS_ALLOWED = 1;

    public boolean giveAccess() {
        return 42 == ACCESS_ALLOWED;
    }

}
