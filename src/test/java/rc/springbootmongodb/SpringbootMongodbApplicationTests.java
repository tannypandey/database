package rc.springbootmongodb;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringbootMongodbApplicationTests {

    // Test to check if the new user returns the correct parameters
    @Test
    public void createUserTest() {
        User u = new User("tr16785",
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
        assertEquals(u.getName(),"John");
        assertEquals(u.getAge(),35);
        assertEquals(u.getHeight(),150);
        assertEquals(u.getWeight(),60);
        assertEquals(u.getTimeLimit(),2);
    }

    // Test to check if the new workout returns the correct parameters
    @Test
    public void createWorkoutTest(){
        Workouts w= new Workouts("10 days weight loss","High Intensity Intensive Training",
                Arrays.asList(new Exercise("burpees",1)),Arrays.asList(new String("none")));
        assertEquals(w.getExercise(), new ArrayList<Exercise>((Collection<? extends Exercise>) new Exercise("burpees",1)));
        assertEquals(w.getName(),"10 days weight loss");
        assertEquals(w.getDescription(),"High Intensity Intensive Training");
    }

    // Test to check the user has the height in correct range
    @Test
    public void checkHeight() {
        User u = new User("tr16785",
                "Katherine",
                35,
                210,
                60,
                Arrays.asList(new Workouts("Evening Workout",
                                "New routine for the month",
                                Arrays.asList(new Exercise("Running",1)),
                                Arrays.asList(new String("tags"))
                        )
                ),
                2
        );
        assertEquals(u.getHeight(), 0);

        User u1 =new User("tr16785",
                "Katherine",
                35,
                10,
                60,
                Arrays.asList(new Workouts("Evening Workout",
                                "New routine for the month",
                                Arrays.asList(new Exercise("Running",1)),
                                Arrays.asList(new String("tags"))
                        )
                ),
                2
        );        assertEquals(u1.getHeight(), 0);
    }

    // Test to check the user has the weight in correct range
    @Test
    public void checkWeight(){
        User p = new User("tr16785",
                "Katherine",
                35,
                150,
                300,
                Arrays.asList(new Workouts("Evening Workout",
                                "New routine for the month",
                                Arrays.asList(new Exercise("Running",1)),
                                Arrays.asList(new String("tags"))
                        )
                ),
                2
        );
        assertEquals(p.getWeight(), 0);

        User p1 = new User("tr16785",
                "Katherine",
                35,
                150,
                10,
                Arrays.asList(new Workouts("Evening Workout",
                                "New routine for the month",
                                Arrays.asList(new Exercise("Running",1)),
                                Arrays.asList(new String("tags"))
                        )
                ),
                2
        );
        assertEquals(p1.getWeight(), 0);
    }

    // Test to check the user has correct age
    @Test
    public void checkAge(){
        User t1 = new User("tr16785",
                "Katherine",
                10,
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
        assertEquals(t1.getAge(),0);

        User p1 = new User("tr16785",
                "Katherine",
                103,
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
        assertEquals(p1.getAge(),0);
    }

    // Test to check if workout time limit exceeds user time limit
    @Test
    public void checkTimeLimit(){
        User u = new User("tr16785",
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
        assertTrue(u.getTimeLimit()>u.getWorkoutTime());

        User u1 = new User("tr16785",
                "Katherine",
                35,
                150,
                60,
                Arrays.asList(new Workouts("Evening Workout",
                                "New routine for the month",
                                Arrays.asList(new Exercise("Running",3)),
                                Arrays.asList(new String("tags"))
                        )
                ),
                2
        );
        assertNull(u1.getWorkouts());
    }

}
