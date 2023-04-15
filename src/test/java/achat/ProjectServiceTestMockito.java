package achat;

import static org.mockito.Mockito.times;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.ExamenScrumApplication;
import tn.esprit.entities.Project;
import tn.esprit.entities.User;
import tn.esprit.repositories.ProjectRepository;
import tn.esprit.repositories.UserRepository;
import tn.esprit.services.ExamServiceImpl;
import tn.esprit.services.IExamService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest(classes = ExamenScrumApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
@Slf4j
class ProjectServiceTestMockito {

	
	@Mock
	ProjectRepository ProjectRepository;
	
	@Mock
	UserRepository userRepository;
	
	@InjectMocks	
	ExamServiceImpl examServiceImpl;
	
	Project back= new Project(0, "springboot project", "backend project part", null, null);
	Project front= new Project(1, "angular project", "frontend project part", null, null);

  	User jawher = new User(0, "jawher.benhamed@esprit.com", "noPass", "Ben hamed", "Jawher", null, null, null);
  	
  	@Test void initTest() {
  		System.out.println("test initializer");

  	}
  		
	
	  @Test void testAddUser() {
	  		
		  System.out.println("test Adding User ");
		  examServiceImpl.addUser(jawher);
		  Mockito.verify(userRepository , times(0)).save(jawher); 
	  }
	  
//	  @Test void testAddFront() {
//		  System.out.println("test Add Project front ");
//		  examServiceImpl.addProject(front);
//		  Mockito.verify(ProjectRepository , times(0)).save(front); 
//		  }
//	  
//	  @Test void testAddBack() { 
//		  System.out.println("test Add Project backend ");
//		  examServiceImpl.addProject(back);
//		  Mockito.verify(ProjectRepository , times(0)).save(back);
//		  }
	 
      
}
