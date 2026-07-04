package hexlet.code.schemas;

import java.util.Map;

public class MapSchema implements BaseSchema<Map> {
    private boolean shape;
    private boolean required;
    private boolean sizeOf;
    private int size;
    private Map<String, BaseSchema> shapeSchemas;

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
        if (shape) {
            if (shapeSchemas != null || !shapeSchemas.isEmpty()) {
                for (Map.Entry<String, BaseSchema> entry : shapeSchemas.entrySet()) {
                    String key = entry.getKey();
                    Object value = map.get(key);
                    BaseSchema schema = entry.getValue();
                    if (!schema.isValid(value)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public <T> void shape(Map<String, BaseSchema<T>> map) {
        this.shape = true;
        this.shapeSchemas = Map.copyOf(map);
    }
}
