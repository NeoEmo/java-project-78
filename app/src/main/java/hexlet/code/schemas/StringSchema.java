package hexlet.code.schemas;

public class StringSchema{
    private boolean required;
    private int minLength;
    private String contains;
    private boolean hasContains = false;
    private boolean hasMinLength = false;

    public boolean isValid(String string) {
        if (required && (string == null || string.isEmpty())) {
            return false;
        }

        if (hasMinLength) {
            if (minLength > string.length()) {
                return false;
            }
        }

        if (hasContains) {
            if (!string.contains(contains)) {
                return false;
            }
        }

        if (!required && (string == null || string.isEmpty())) {
            return true;
        }

        return true;
    }

    public void required() {
        this.required = true;
    }

    public StringSchema minLength(int length) {
        this.minLength = length;
        hasMinLength = true;
        return this;
    }

    public StringSchema contains(String str) {
        this.contains = str;
        hasContains = true;
        return this;
    }
}
