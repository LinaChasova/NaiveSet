import java.util.Arrays;

/**
 * Created by AlinaCh on 05.02.2017.
 */
public class BitSet {

    private int size;
    private long[] myBitSet = new long[1];

    /**
     * creates BitSet with 1 long (64 elements) and makes it 0 (all elements are false)
     */
    public BitSet() {
        size = 1;
        myBitSet[0] = 0;
    }

    /**
     * makes ith element "true"
     * @param i
     */
    public void set(int i) {
        while (i / 64 >= myBitSet.length) {
            sizeExtension(i);
        }
        myBitSet[i / 64] = (1 << i) | myBitSet[i / 64];
    }

    /**
     *
     * @param i
     * @return whether ith is "true" or "false"
     */
    public boolean get(int i) {
        if (i / 64 > myBitSet.length) throw new ArrayIndexOutOfBoundsException("BitSet overflow");
        return (myBitSet[i / 64] & (1 << i)) == 1 << i;
    }

    /**
     * extends bitset if needed
     * @param i
     */
    private void sizeExtension(int i) {
        myBitSet = Arrays.copyOf(myBitSet, myBitSet.length * 2);
        size = size * 2;
    }
}
