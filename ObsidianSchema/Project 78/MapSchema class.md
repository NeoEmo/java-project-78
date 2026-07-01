// Старая редакция
1. Не совсем понятно, класс ли это, но вызов происходит так:
	1) Map<String, BaseSchema<String>> schemas = new HashMap<>();
	   2) schemas.put("firstName", v.string().requared());
	   3) schemas.put("lastName", v.string().requared().minLength(2));
	   4) MapSchema schema = v.map.sizeOf(2).shape(shemas);
   2. Методы: Неизвестно
Как видно в 4) всё таки есть класс MapSchema, который работает с Map<String, BaseSchema<String>> shemas.
А так ещё виден интерфейс, с которого все скорее всего наследуются, BaseSchema