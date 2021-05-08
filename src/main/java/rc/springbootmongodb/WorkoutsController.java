package rc.springbootmongodb;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workouts")
public class WorkoutsController {
    private WorkoutRepository workoutRepository;

    public WorkoutsController(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    @GetMapping("/all")
    public List<Workouts> getAll(){
        List<Workouts> workouts = this.workoutRepository.findAll();
        return  workouts;

    }
    @PutMapping
    public void insert (@RequestBody Workouts workout){
        this.workoutRepository.insert(workout);
    }

    @PostMapping
    public void update(@RequestBody Workouts workout){
        this.workoutRepository.save(workout);
    }

    @DeleteMapping
    public void delete(@RequestBody Workouts workout){
        this.workoutRepository.delete(workout);
    }

}
