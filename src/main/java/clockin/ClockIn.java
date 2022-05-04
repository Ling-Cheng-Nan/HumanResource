package clockin;

import java.util.Date;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ClockIn {
    
    public String id;

    public String person_name;
    
    public Date check_date;
}
