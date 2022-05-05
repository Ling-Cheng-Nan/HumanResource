package clockin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClockInRepository extends JpaRepository<ClockIn, Long>{
    
}
