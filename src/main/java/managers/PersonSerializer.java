// PersonSerializer.java
package managers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import models.Person;
import java.io.IOException;

public class PersonSerializer extends JsonSerializer<Person> {
    @Override
    public void serialize(Person value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(value.getName() + ";" + value.getPassportID() + ";" + value.getLocation());
    }
}