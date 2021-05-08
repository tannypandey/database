package rc.springbootmongodb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// providing sample data as a start for the database
// has 2 users and 2 sample workouts
@Component
public class DbSeeder implements CommandLineRunner {
    private UserRepository userRepository;
    private WorkoutRepository workoutRepository;

    public DbSeeder(UserRepository userRepository, WorkoutRepository workoutRepository ){
        this.userRepository = userRepository;
        this.workoutRepository = workoutRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User teacher = new User("tr16785",
                "Katherine",
                35,
                150,
                60,
                Arrays.asList(new Workouts("Evening Workout",
                        "New routine for the month",
                        Arrays.asList(new Exercise("Running",1)),
                        Arrays.asList(new String("tags"))
                        )
                ),
                2
        );
        User coder = new User("cd56788", "Ben",
                24,
                170,
                75,
                Arrays.asList(new Workouts("Morning Workout",
                                "New routine for the week",
                                Arrays.asList(new Exercise("Cycling",2)),
                                Arrays.asList(new String("tags"))
                        )
                ),
                3
        );
        Workouts sample1 = new Workouts("Morning Workout",
                "New routine for the week",
                Arrays.asList(new Exercise("Climbing",2)),
                Arrays.asList(new String("tags"))
        );
        Workouts sample2 = new Workouts("Morning Workout",
                "New routine for the week",
                Arrays.asList(new Exercise("Rowing",1)),
                Arrays.asList(new String("tags"))
        );

        // drop all the users
        this.userRepository.deleteAll();

        // drop all workouts
        this.workoutRepository.deleteAll();

        //add users to our database
        this.userRepository.save(teacher);
        this.userRepository.save(coder);

        //add workout to our database
        this.workoutRepository.save(sample1);
        this.workoutRepository.save(sample2);
    }
}
