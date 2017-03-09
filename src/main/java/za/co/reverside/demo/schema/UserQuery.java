package za.co.reverside.demo.schema;

import org.springframework.data.annotation.Id;

public class UserQuery {
  
    @Id
    private String id;

    private String firstname;

    private String lastname;

    private String email;

    private String phone;
    
}
