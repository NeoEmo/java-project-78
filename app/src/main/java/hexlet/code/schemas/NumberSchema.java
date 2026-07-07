package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() {
        this.required = true;
        return this;
    }

    public NumberSchema positive() {
        addCheck("positive", value -> value > 0);
//        {
//            if (required && value == null) {
//                return false;
//            }
//
//            if (!required && value == null) {
//                return true;
//            } else {
//                return value > 0;
//            }
//        });
        return this;
    }

    public void range(int min, int max) {
        addCheck("range", value -> value >= min && value <= max);
    }
}
