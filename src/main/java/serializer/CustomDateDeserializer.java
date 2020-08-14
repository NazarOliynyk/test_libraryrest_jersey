package serializer;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static client.CustomClientBuilder.logger;

public class CustomDateDeserializer extends StdDeserializer<LocalDate> {
    public CustomDateDeserializer() {
        this(null);
    }

    private CustomDateDeserializer(Class t) {
        super(t);
    }

    @Override
    public LocalDate deserialize(JsonParser jp, DeserializationContext dc) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate parsed = null;
        try {
            parsed = LocalDate.parse(jp.getValueAsString(), formatter);
        } catch (DateTimeParseException e) {
            logger.error(e.getMessage());
        }

        return parsed;
    }
}