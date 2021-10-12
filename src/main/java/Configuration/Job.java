package Configuration;

import org.json.JSONObject;

import java.util.Objects;

public class Job {
    private final String name;
    private final String source;
    private final String target;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return getName().equals(job.getName()) && getSource().equals(job.getSource()) && getTarget().equals(job.getTarget());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSource(), getTarget());
    }

    public JSONObject toJSONObject() {
        JSONObject jobObject = new JSONObject();
        jobObject.put("name", getName());
        jobObject.put("source", getSource());
        jobObject.put("target", getTarget());
        return jobObject;
    }
}
