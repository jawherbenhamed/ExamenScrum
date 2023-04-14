package achat;

import static org.mockito.Mockito.times;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.entities.Project;
import tn.esprit.entities.User;
import tn.esprit.repositories.ProjectRepository;
import tn.esprit.repositories.UserRepository;
import tn.esprit.services.ExamServiceImpl;
import tn.esprit.services.IExamService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
@RunWith(JUnit4.class)
@Slf4j
public class ProjectServiceTestMockito {

	@Autowired
	IExamService ps ;
	
	@Mock
	ProjectRepository ProjectRepository;
	UserRepository userRepository;
	@InjectMocks
	
	ExamServiceImpl examServiceImpl;
	
	Project back= new Project(0, "springboot project", "backend project part", null, null);
	Project front= new Project(1, "angular project", "frontend project part", null, null);
    List<Project> listProjects = new ArrayList<Project>() {
        {
            add(new Project(0, "springboot project", "backend project part", null, null));
            add(new Project(1, "angular project", "frontend project part", null, null));
        }
      };
  	User jawher = new User(0, "jawher.benhamed@esprit.com", "noPass", "Ben hamed", "Jawher", null, null, null);

      @Test
      void testAddUser()
     {
         examServiceImpl.addUser(jawher);
         Mockito.verify(userRepository , times(0)).save(jawher);
     }

      @Test
      void testAddFront()
     {
         examServiceImpl.addProject(front);
         Mockito.verify(ProjectRepository , times(0)).save(front);
     }
      @Test
      void testAddBack()
     {
         examServiceImpl.addProject(back);
         Mockito.verify(ProjectRepository , times(0)).save(back);
     }
      
}
