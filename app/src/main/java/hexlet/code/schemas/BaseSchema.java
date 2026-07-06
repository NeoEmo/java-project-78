package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    protected Map<String, Predicate<T>> checks = new HashMap<>();
    protected boolean required = false;

    protected final void addCheck(String name, Predicate<T> validate) {
        checks.put(name, validate);
    }

    public final boolean isValid(T value) {
        if (required && value == null) {
            return false;
        }

        if (!required && value == null) {
            return true;
        }

        if (checks.isEmpty()) {
            return true;
        }

        for (Map.Entry<String, Predicate<T>> entry : checks.entrySet()) {
            if (!entry.getValue().test(value)) {
                return false;
            }
        }
        return true;
    }
}
