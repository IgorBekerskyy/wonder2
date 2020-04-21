package ua.lviv.iot.spring.labseven.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.spring.labseven.data.GroupRepository;
import ua.lviv.iot.spring.labseven.rest.RestAplication.model.Group;


@Service
public class GroupService {
	@Autowired
	private GroupRepository groupRepository;

	public List<Group> getGroups(){
		return groupRepository.findAll();
	}
	

}
