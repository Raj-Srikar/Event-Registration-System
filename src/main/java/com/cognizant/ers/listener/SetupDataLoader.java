package com.cognizant.ers.listener;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cognizant.ers.entity.Privilege;
import com.cognizant.ers.entity.Role;
import com.cognizant.ers.entity.User;
import com.cognizant.ers.repo.PrivilegeRepository;
import com.cognizant.ers.repo.RoleRepository;
import com.cognizant.ers.repo.UserRepository;

import jakarta.transaction.Transactional;

public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {
	
	private boolean alreadySetup;
	
	@Autowired
    private UserRepository userRepository;
 
    @Autowired
    private RoleRepository roleRepository;
 
    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {
    	if (alreadySetup)
            return;

		Privilege viewEventPrivilege = createPrivilegeIfNotFound("VIEW_EVENT_PRIVILEGE");
		Privilege viewRegisteredEventsPrivilege = createPrivilegeIfNotFound("VIEW_REGISTERED_EVENTS_PRIVILEGE");
		Privilege viewMyEventsPrivilege = createPrivilegeIfNotFound("VIEW_MY_EVENTS_PRIVILEGE");
		Privilege createEventPrivilege = createPrivilegeIfNotFound("CREATE_EVENT_PRIVILEGE");
		Privilege editEventPrivilege = createPrivilegeIfNotFound("EDIT_EVENT_PRIVILEGE");
		Privilege registerEventPrivilege = createPrivilegeIfNotFound("REGISTER_EVENT_PRIVILEGE");
		Privilege viewParticipantsPrivilege = createPrivilegeIfNotFound("VIEW_PARTICIPANTS_PRIVILEGE");
 
        List<Privilege> OrganizerPrivileges = Arrays.asList(viewEventPrivilege,
        		viewMyEventsPrivilege,
        		createEventPrivilege,
        		editEventPrivilege,
        		viewParticipantsPrivilege
        		);
        List<Privilege> ParticipantPrivileges = Arrays.asList(
        		viewEventPrivilege,
        		viewRegisteredEventsPrivilege,
        		registerEventPrivilege
        		);
        createRoleIfNotFound("ROLE_ORGANIZER", OrganizerPrivileges);
        createRoleIfNotFound("ROLE_PARTICIPANT", ParticipantPrivileges);

        Role orgRole = roleRepository.findByName("ROLE_ORGANIZER");
        User user = new User();
        user.setFirstname("Test");
        user.setLastname("Test");
        user.setPassword(passwordEncoder.encode("test"));
        user.setEmail("test@test.com");
        user.setRoles(Arrays.asList(orgRole));
        userRepository.save(user);

        alreadySetup = true;
	}

    @Transactional
    Privilege createPrivilegeIfNotFound(String name) {
 
        Privilege privilege = privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege(name);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    Role createRoleIfNotFound(
      String name, Collection<Privilege> privileges) {
 
        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }
}
