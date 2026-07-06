package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        this.required = true;
        addCheck("required", value -> !value.isEmpty());
        return this;
    }

    public StringSchema minLength(int lengthOf) {
        addCheck("minLength", value -> value.toString().length() > lengthOf);
        return this;
    }

    public StringSchema contains(String str) {
        addCheck("contains", value -> value.toString().contains(str));
        return this;
    }
}
