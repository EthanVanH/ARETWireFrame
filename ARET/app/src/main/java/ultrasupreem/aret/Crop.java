package ultrasupreem.aret;


public class Crop {
    String name;
    String type;
    String description;
    String instruction;

    public Crop(String name, String type, String description, String instruction) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.instruction = instruction;
    }

    @Override
    public String toString() {
        return name;
    }
}
