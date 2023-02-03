package scratch.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import scratch.crud.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    Course findByName(String name);


}
