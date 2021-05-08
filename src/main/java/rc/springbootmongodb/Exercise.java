package rc.springbootmongodb;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection= "Exercise")
public class Exercise {
    private String Name;
    private int time;

    public Exercise(String Name, int time) {
        this.Name = Name;
        this.time = time;
    }

    public String getName() {return Name;}
    public int getTime() {return time;}

}

