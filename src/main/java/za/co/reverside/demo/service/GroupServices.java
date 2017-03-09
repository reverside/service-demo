package za.co.reverside.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.co.reverside.demo.model.Group;
import za.co.reverside.demo.repository.GroupRepository;

@RestController
public class GroupServices {
    
    @Autowired
    private GroupRepository groupRepository;
    
    
    @RequestMapping(path = "api/hello/group")
    public String hello(){
        return "Hello";
    }
    
    @RequestMapping(path="api/groups", method = RequestMethod.POST, consumes = "application/json")
    public void createGroup(@RequestBody Group group){
        this.groupRepository.insert(group);
    }
    @RequestMapping(path="api/groups", method = RequestMethod.GET, produces = "application/json")
    public List<Group> findGroups(){
        return this.groupRepository.findAll();
    }
}
