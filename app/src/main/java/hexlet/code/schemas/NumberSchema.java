package hexlet.code.schemas;

public class NumberSchema implements BaseSchema<Integer> {
    private boolean required;
    private boolean positive;
    private boolean range;
    private Integer min;
    private Integer max;

    @Override
    public boolean isValid(Integer integer) {
        if (!required && integer == null) {
            return true;
        }

        if (required && integer == null) {
            return false;
        }

        if  (range && (integer < min || integer > max)) {
            return false;
        }

        if (positive && integer <= 0) {
            return false;
        }

        return true;
    }

    public void required() {
        this.required = true;
    }

    public NumberSchema positive() {
        this.positive = true;
        return this;
    }

    public void range(int minValue, int maxValue) {
        this.range = true;
        this.min = minValue;
        this.max = maxValue;
    }
}
