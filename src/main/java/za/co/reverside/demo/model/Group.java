package za.co.reverside.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
public class Group {
    
    @Id
    private String id;
    
    private String name;
    
    private String description;
}
