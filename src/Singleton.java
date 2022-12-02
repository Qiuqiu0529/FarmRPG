
import java.util.function.Supplier;

abstract class Singleton<S> {
    private final Supplier<S> singletonInstanceMethod;
    public Singleton(final Supplier<S> singletonInstanceMethod) {
    this.singletonInstanceMethod = singletonInstanceMethod;
  }
}

