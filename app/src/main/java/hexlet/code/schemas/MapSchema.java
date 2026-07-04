package hexlet.code.schemas;

import java.util.Map;

public class MapSchema implements BaseSchema<Map> {
    private boolean required;
    private boolean sizeOf;
    private int size;

    public void required() {
        this.required = true;
    }

    public MapSchema sizeof(int sizeSchema) {
        this.sizeOf = true;
        this.size = sizeSchema;
        return this;
    }

    @Override
    public boolean isValid(Map map) {
        if (!required && map == null) {
            return true;
        }
        if (required && map == null) {
            return false;
        }
        if (sizeOf && map.size() < size) {
            return false;
        }
        return true;
    }
}
