package za.co.reverside.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.co.reverside.demo.model.Group;
import za.co.reverside.demo.repository.GroupRepository;

@RestController
public class GroupService {
    
    @Autowired
    private GroupRepository groupRepository;
    
    @RequestMapping(path="api/groups", method = RequestMethod.POST, consumes = "application/json")
    public void createGroup(@RequestBody Group group){
        this.groupRepository.insert(group);
    }
    
    @RequestMapping(path="api/groups", method = RequestMethod.GET, produces = "application/json")
    public List<Group> findGroups(){
        return this.groupRepository.findAll();
    }
    
    @RequestMapping(path="api/groups/{groupId}", method = RequestMethod.GET, produces = "application/json")
    public Group findGroup(@PathVariable("groupId") String id ){
            return this.groupRepository.findOne(id);
    }
    
        
    @RequestMapping(path="api/groups/{groupId}", method = RequestMethod.PUT, consumes = "application/json")
    public void updateGroup(@PathVariable  String groupId, @RequestBody Group request){
        Group group = this.groupRepository.findOne(groupId);
        if(group != null){
            group.setName(request.getName());
            group.setDescription(request.getDescription());
            groupRepository.save(group);
        }else
        {
            throw new RuntimeException ("No such group");
        }
        
    }
    
    @RequestMapping(path="api/groups/{groupId}", method = RequestMethod.DELETE)
    public void deleteGroup(@PathVariable("groupId") String id){
        Group group = this.groupRepository.findOne(id);
        if( group == null){
            throw new RuntimeException ("No group found");
        }else{
            groupRepository.delete(id);
        }
    }

}
