

package za.co.reverside.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class UserQuery {
  
    @Id
    private String id;

    private String firstname;

    private String lastname;

    private String email;

    private String phone;
    
}
