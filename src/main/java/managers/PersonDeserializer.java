package managers;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import models.Location;
import models.Person;
import java.io.IOException;

public class PersonDeserializer extends JsonDeserializer<Person> {
    @Override
    public Person deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String[] parts = p.getValueAsString().split(";");
        Person person = new Person();
        person.setName(parts[0]);
        person.setPassportID(parts[1]);
        if (parts.length > 2 && !parts[2].equals("null")) {
            person.setLocation(parseLocation(parts[2]));
        }
        return person;
    }

    private Location parseLocation(String str) {
        String[] locParts = str.replace("Location{", "")
                .replace("}", "")
                .split(",");
        Location loc = new Location();
        for (String part : locParts) {
            String[] kv = part.split("=");
            String key = kv[0].trim();
            String value = kv[1].trim();
            switch (key) {
                case "x": loc.setX(Double.parseDouble(value)); break;
                case "y": loc.setY(Float.parseFloat(value)); break;
                case "z": loc.setZ(Long.parseLong(value)); break;
                case "name": loc.setName(value); break;
            }
        }
        return loc;
    }
}