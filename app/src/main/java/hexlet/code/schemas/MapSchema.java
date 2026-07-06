package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map> {
    private Map<String, BaseSchema> shapeSchemas;

    public MapSchema required() {
        this.required = true;
        return this;
    }

    public MapSchema sizeof(int size) {
        addCheck("sizeof", value -> value.size() == size);
        return this;
    }

    public <T> MapSchema shape(Map<String, BaseSchema<T>> map) {
        this.shapeSchemas = Map.copyOf(map);
        addCheck("shape", map1 -> {
            if (shapeSchemas == null || shapeSchemas.isEmpty()) {
                return true;
            }

            for (Map.Entry<String, BaseSchema> entry : shapeSchemas.entrySet()) {
                String key = entry.getKey();
                Object value = map1.get(key);
                BaseSchema schema = entry.getValue();

                if (!schema.isValid(value)) {
                    return false;
                }
            }
            return true;
        });
        return this;
    }

}
