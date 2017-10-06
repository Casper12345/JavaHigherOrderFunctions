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

  /**
   * Implementation of filter function.
   *
   * @param lst list of generic type A
   * @param returnList list of generic type A
   * @param predicate functional interface
   * @param <A> generic type A
   * @return list of A
   */
  public <A> List<A> filter(List<A> lst, List<A> returnList, Predicate<A> predicate) {
    if (lst.isEmpty()) {
      return returnList;
    } else {
      A h = lst.remove(0);
      if (predicate.test(h)) {
        returnList.add(h);
      }
      filter(lst, returnList, predicate);
    }
    return returnList;
  }

}

/**
 * Functional interface with single abstract method.
 *
 * @param <A> generic param
 * @param <B> generic param
 */
@FunctionalInterface
interface Function<A, B> {

  B apply(A a);
}

/**
 * Functional interface with single abstract method.
 *
 * @param <A> generic param
 */
@FunctionalInterface
interface Predicate<A> {

  boolean test(A a);
}



