package rc.springbootmongodb;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserRepository userRepository;
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    public List<User> getAll(){
        List<User> users = this.userRepository.findAll();
        System.out.println(users);
        return users;
    }

    @PutMapping
    public void insert (@RequestBody User user){
        this.userRepository.insert(user);
    }

    @PostMapping
    public void update(@RequestBody User user){
        this.userRepository.save(user);
    }

    @DeleteMapping
    public void delete(@RequestBody User user){
        this.userRepository.delete(user);
    }

    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable("id") String id){
      Optional<User> user = this.userRepository.findById(id);
        return user;
    }

    @GetMapping("/{id}/height")
    public int getHeight(@PathVariable("id") String id){
        Optional<User> user = this.userRepository.findById(id);
        return user.get().getHeight();
    }

    @GetMapping("/{id}/weight")
    public int getWeight(@PathVariable("id") String id){
        Optional<User> user = this.userRepository.findById(id);
        return user.get().getWeight();
    }

    @GetMapping("/{id}/name")
    public String getName(@PathVariable("id") String id){
        Optional<User> user = this.userRepository.findById(id);
        return user.get().getName();
    }

    @GetMapping("/{id}/workouts")
    public List<Workouts> getWorkouts(@PathVariable("id") String id){
        Optional<User> user = this.userRepository.findById(id);
        return user.get().getWorkouts();
    }
}
