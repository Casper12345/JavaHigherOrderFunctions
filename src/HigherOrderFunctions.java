import java.util.List;

public class HigherOrderFunctions {

  /**
   * Implementation of map function.
   *
   * @param lst list of generic type A
   * @param returnList list of generic type B
   * @param function functional interface
   * @param <A> generic type A
   * @param <B> generic type B
   * @return list of B.
   */
  public <A, B> List<B> map(List<A> lst, List<B> returnList, Function<A, B> function) {
    if (lst.isEmpty()) {
      return returnList;
    } else {
      returnList.add(function.apply(lst.remove(0)));
      map(lst, returnList, function);
    }
    return returnList;

  }

}

/**
 * Functional interface with simple abstract method.
 *
 * @param <A> generic param
 * @param <B> generic param
 */
interface Function<A, B> {

  B apply(A a);
}




