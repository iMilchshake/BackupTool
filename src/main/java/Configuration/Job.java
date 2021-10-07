package Configuration;

import org.json.JSONObject;

public class Job {
    private String name;
    private String source;
    private String target;

    public Job(String name, String source, String target) {
        this.name = name;
        this.source = source;
        this.target = target;
    }

    public Job(JSONObject jobObject) {
        this.name = jobObject.getString("name");
        this.source = jobObject.getString("source");
        this.target = jobObject.getString("target");
    }

    public String getName() {
        return name;
    }

    public String getSource() {
        return source;
    }

    public String getTarget() {
        return target;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", source='" + source + '\'' +
                ", target='" + target + '\'';
    }

    public JSONObject toJSONObject() {
        JSONObject jobObject = new JSONObject();
        jobObject.put("name", getName());
        jobObject.put("source", getSource());
        jobObject.put("target", getTarget());
        return jobObject;
    }
}
