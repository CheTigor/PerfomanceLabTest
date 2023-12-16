import java.util.Map;

public class Values {

    private Map<Long, String> values;

    public Values(Map<Long, String> values) {
        this.values = values;
    }

    public Values() {
    }

    public Map<Long, String> getValues() {
        return values;
    }
}
