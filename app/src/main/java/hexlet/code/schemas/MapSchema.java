package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map> {

    public MapSchema required() {
        this.required = true;
        return this;
    }

    public MapSchema sizeof(int size) {
        addCheck("sizeof", value -> value.size() == size);
        return this;
    }

    public <T> MapSchema shape(Map<String, BaseSchema<T>> map) {
        Map<String, BaseSchema> copyOfMap = Map.copyOf(map);
        addCheck("shape", map1 -> {
            if (copyOfMap == null || copyOfMap.isEmpty()) {
                return true;
            }

            for (Map.Entry<String, BaseSchema> entry : copyOfMap.entrySet()) {
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
