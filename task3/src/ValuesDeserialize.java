import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.HashMap;

public class ValuesDeserialize implements JsonDeserializer<Values> {

    @Override
    public Values deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        final Values result = new Values(new HashMap<>());
        JsonArray tests = json.getAsJsonObject().getAsJsonArray("values");
        for (JsonElement element : tests) {
            result.getValues().put(element.getAsJsonObject().get("id").getAsLong(),
                    element.getAsJsonObject().get("value").getAsString());
        }
        return result;
    }
}
