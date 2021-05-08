package rc.springbootmongodb;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection= "Workouts")
public class Workouts {
    private String Name;
    private String description;
    private List<Exercise> exercise;
    private List<String> tags;

    protected Workouts() {
        this.exercise = new ArrayList<>();
        this.tags = new ArrayList<>();
    }

    public Workouts(String Name, String description, List<Exercise> exercise, List<String> tags){
        this.Name = Name;
        this.description = description;
        this.exercise = exercise;
        this.tags = tags;
    }

    public String getName() {return Name;}
    public String getDescription() {return description;}
    public List<Exercise> getExercise() {return exercise;}
    public List<String> getTags() {return tags;}

}
