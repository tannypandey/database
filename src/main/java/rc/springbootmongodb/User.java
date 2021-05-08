package rc.springbootmongodb;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Document(collection = "Users")
public class User {
    @Id private String id;
    private String Name;
    private int age;
    private int height;
    private int weight;
    private List<Workouts> workouts;
    private int TimeLimit;

    protected User(){
        this.workouts= new ArrayList<>();
    }

    public User(String id, String Name, int age,int height, int weight, List<Workouts> workouts, int TimeLimit) {
        this.Name = Name;
        if (age > 12 && age < 99)
            this.age = age;
        else {
            System.out.println("Enter valid age");
        }

        if (height > 140 && height < 210)
            this.height = height;
        else {
            System.out.println("Enter valid height");
        }

        if (weight > 20 && weight < 250)
            this.weight = weight;
        else {
            System.out.println("Enter Valid weight");
        }

        this.TimeLimit = TimeLimit;

        int sumOfTime = 0;
        for (Workouts i : workouts) {
            for(Exercise e : i.getExercise())
            sumOfTime += e.getTime();
        }
        if (this.TimeLimit > sumOfTime)
            this.workouts = workouts;
        else {
            this.workouts = null;
            System.out.println("The time limit is exceeding");
        }
    }

    public String getId(){
        return id;}
    public String getName(){ return Name;}
    public int getAge(){return age;}
    public int getHeight(){return height;}
    public int getWeight(){return weight;}
    public int getTimeLimit(){return TimeLimit;}
    public List<Workouts> getWorkouts(){return workouts;}
    public int getWorkoutTime(){
        int sumOfTime=0;
        for (Workouts i : workouts) {
            for (Exercise e : i.getExercise())
                sumOfTime += e.getTime();
        }
            return sumOfTime;
    }
}
