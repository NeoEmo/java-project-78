package hexlet.code.schemas;


import hexlet.code.Validator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class StringSchemaTest {

    @Test
    public void stringSchemaTest() {
        var v = new Validator();
        var schema = v.string();

        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));

        schema.required();

        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid("what does the fox say"));
        assertTrue(schema.isValid("hexlet"));

        assertTrue(schema.contains("wh").isValid("what does the fox say"));
        assertTrue(schema.contains("what").isValid("what does the fox say"));
        assertFalse(schema.contains("Ni ni ni ni ni ni").isValid("what does the fox say"));
        assertFalse(schema.isValid("what does the fox say"));

        var schema1 = v.string();
        assertTrue(schema1.minLength(10).minLength(4).isValid("Hexlet"));
    }

    @Test
    public void stringSchemaTest2() {
        var v = new Validator();
        var schema = v.string();
        var expected = "Validator";
        var expected2 = "StringSchema";

        assertEquals(expected, v.getClass().getSimpleName());
        assertEquals(expected2, schema.getClass().getSimpleName());
    }
}
