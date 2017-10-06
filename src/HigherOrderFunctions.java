import java.util.List;

public class HigherOrderFunctions {


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

interface Function<A, B> {

  B apply(A a);
}




