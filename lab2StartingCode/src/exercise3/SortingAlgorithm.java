package exercise3;
import java.util.List;


/**
 * The interface for the exercise algorithms 
 * @author Yue (Amir) Zhou
 * @param <E>
 */
public interface SortingAlgorithm {
	public abstract <E extends Comparable<? super E>> List<E> sortDescending(List<E> input);
}
