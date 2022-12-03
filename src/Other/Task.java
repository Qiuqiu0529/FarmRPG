package Other;
import java.util.Optional;
public abstract class Task {
    final void executeWith(Callback callback) {
        execute();
        Optional.ofNullable(callback).ifPresent(Callback::Call);
    }

    public abstract void execute();
}
