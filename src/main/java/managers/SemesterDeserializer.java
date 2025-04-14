package managers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import models.Semester;
import java.io.IOException;

public class SemesterDeserializer extends JsonDeserializer<Semester> {
    @Override
    public Semester deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getValueAsString();
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        return Semester.valueOf(value.toUpperCase());
    }
}