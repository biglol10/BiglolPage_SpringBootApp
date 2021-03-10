package com.biglolPage.introducingBiglolPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.biglolPage.introducingBiglolPage.domain.Course;
import com.biglolPage.introducingBiglolPage.domain.CourseRepository;
import com.biglolPage.introducingBiglolPage.domain.Projects;
import com.biglolPage.introducingBiglolPage.domain.ProjectsRepository;
import com.biglolPage.introducingBiglolPage.domain.Skills;
import com.biglolPage.introducingBiglolPage.domain.SkillsRepository;
import com.biglolPage.introducingBiglolPage.domain.User;
import com.biglolPage.introducingBiglolPage.domain.UserRepository;

@SpringBootApplication
public class IntroducingBiglolPageApplication {
	
	@Autowired
	private SkillsRepository repository;
	
	@Autowired
	private ProjectsRepository projectRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired 
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(IntroducingBiglolPageApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner() {
		return args -> {
			// username: admin password: admin
			userRepository.save(new User("admin",
		      "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG", 
		      "ADMIN"));

			// Skills
			repository.save(new Skills("Html", "./Images/Skills/logo-html-5.png", "Developing using HTML-5", 3.5));
			repository.save(new Skills("CSS", "./Images/Skills/logo-css.png", "Can use basics of CSS and use functions that change according to the screen", 4.0));
			repository.save(new Skills("Javascript", "./Images/Skills/logo-js.png", "Learned from online lectures and e-books, and continuously refer MDN documentaion", 4.0));
			repository.save(new Skills("Jquery", "./Images/Skills/logo-jquery.png", "Has experience in developing MES using Jquery in the Smart-Factory field", 4.0));
			repository.save(new Skills("React", "./Images/Skills/logo-react.png", "Clone project development through YouTube and Online lectures", 3.5));
			repository.save(new Skills("ASP.NET", "./Images/Skills/logo-aspnet.png", "Self Study on ASP.NET and has MES project experience", 4.5));
			repository.save(new Skills("SpringBoot", "./Images/Skills/logo-springboot.png", "Studying personally through internet after work", 3.0));
			
			// Projects
			projectRepository.save(new Projects("20WebProjects", "./Images/Projects/20WebProjects.png", "https://www.udemy.com/course/web-projects-with-vanilla-javascript/", "An informative subject to learn the basics of JS and CSS", "Brad Traversy", "https://biglol10.github.io/20-web-projects/", 5.0, false));
			projectRepository.save(new Projects("ServerInventory", "./Images/Projects/ServInventory.png","Unavailable", "Used ASP.NET MVC to record plant locations, includes image saving", "Biglol", "Unavailable", 4.0, true));
			projectRepository.save(new Projects("Covid19Tracker", "./Images/Projects/Covid19Tracker.png","https://youtu.be/cF3pIMJUZxM", "Covid-19 Tracker. Simple Project but it was fun", "Clever Programmer", "https://covid-19-tracker-39601.web.app/", 3.5, false));
			projectRepository.save(new Projects("NetflixClone", "./Images/Projects/NetflixClone.png", "https://youtu.be/XtMThy8QKqU", "This was the first clone project I've made. Thanks to this I got interested in React", "Clever Programmer", "https://netflix-clone-14a2a.web.app/", 4.5, false));
			projectRepository.save(new Projects("AmazonClone", "./Images/Projects/AmazonClone.png", "https://youtu.be/RDV3Z1KCBvo", "This was a good project since I could experience react interacting with firebase database. The database and configuration needs to be reworked", "Clever Programmer", "https://myproject-20506.web.app/", 4.5, false));
			projectRepository.save(new Projects("SystemMonitoring", "./Images/Projects/SystemMonitoring.png", "Unavailable", "Used all my knowledge of JS and .NET to create a MES monitoring system", "Biglol", "Unavailable", 4.5, true));
			projectRepository.save(new Projects("FileDistributionProgram", "./Images/Projects/FileDistImage.png", "Unavailable", "Used Winform and multi tasks to deploy neccessary files asyncronously", "Biglol", "Unavailable", 4.5, true));
			
			// Courses Taken
			courseRepository.save(new Course("Learn Bootstrap 4 By Creating an Advanced Bootstrap Theme", "https://www.udemy.com/course/learn-bootstrap-4-by-creating-an-advanced-bootstrap-theme/learn/lecture/16715782?start=0#overview", "./Images/Courses/Bootstrap4.png", "Drew Ryan, Website Development and Design Online Instructor", "11,000", 4.0, "T"));
			courseRepository.save(new Course("20 Web Projects With Vanilla Javascript", "https://www.udemy.com/course/web-projects-with-vanilla-javascript/learn/lecture/17832668#overview", "./Images/Courses/20WebProjects.png", "Brad Traversy, Full Stack Web Developer &amp; Instructor at Traversy Media", "17,500", 5.0, "T"));
			courseRepository.save(new Course("React Front to Back", "https://www.udemy.com/course/modern-react-front-to-back/learn/lecture/14969430#content", "./Images/Courses/ReactFrontToBack.png", "Brad Traversy, Full Stack Web Developer &amp; Instructor at Traversy Media", "11,000", 4.0, "T"));
			courseRepository.save(new Course("Master Microservices with Spring Boot and Spring Cloud", "https://www.udemy.com/course/microservices-with-spring-boot-and-spring-cloud/learn/lecture/8004660#overview", "./Images/Courses/MasterMicroservicesSpringBoot.png", "in28Minutes, DevOps, AWS, Docker, Kubernetes, Java & Spring Boot Experts", "15,000", 4.0, "T"));
			courseRepository.save(new Course("Modern React with Redux", "https://www.udemy.com/course/react-redux/learn/lecture/12531044?start=0#overview", "./Images/Courses/ReactRedux.png", "Stephen Grider, Engineering Architect", "13,000", 3.5, "T"));
			courseRepository.save(new Course("The Web Developer Bootcamp", "https://www.udemy.com/course/the-web-developer-bootcamp/learn/lecture/22608008?start=0#overview", "./Images/Courses/WebDevBootcamp.png", "Colt Steele, Developer and Bootcamp Instructor", "13,000", 3.0, "T"));
			courseRepository.save(new Course("Learn Java8 Streams By Coding it with Hands on Example", "https://www.udemy.com/course/learn-java8-streams-by-coding-it-with-hands-on-example/learn/lecture/19137384?start=0#overview", "./Images/Courses/Java8.png", "Arun Ammasai, Teach with passion, from experience, and with an easy-to-understand way of teaching", "14,000", 3.5, "T"));
			courseRepository.save(new Course("The Complete ASP.NET MVC 5 Course", "https://www.udemy.com/course/the-complete-aspnet-mvc-5-course/learn/lecture/4847008#overview", "./Images/Courses/ASPNETMVC.png", "Mosh Hamedani, Passionate Software Engineer", "11,000", 3.5, "T"));
			courseRepository.save(new Course("The Complete JavaScript Course 2021:From Zero to Expert!", "https://www.udemy.com/course/the-complete-javascript-course/learn/lecture/22628657?start=0#overview", "./Images/Courses/JavascriptFromZero.png", "Janas Schmedtmann, Web Developer, Designer", "13,200", 3.0, "T"));
			
			// Courses Interested
			courseRepository.save(new Course("Introduction to MariaDB and HeidiSQL for Beginners", "https://www.udemy.com/course/introduction-to-mariadb-and-heidisql-for-beginners/", "./Images/Courses/I_MariaDB.PNG", "Ahmad Mohey, Software Developer & Instructor", "44,000", 0.0, "I"));
			courseRepository.save(new Course("Step By Step React Native Hybrid Mobile App With Spring Boot", "https://www.udemy.com/course/step-by-step-react-native-hybrid-mobile-app-with-spring-boot/", "./Images/Courses/I_ReactNative.PNG", "Senol Atac, Software Architect", "149,000", 0.0, "I"));
			courseRepository.save(new Course("Spring & Hibernate for Beginners (includes Spring Boot)", "https://www.udemy.com/course/spring-hibernate-tutorial/", "./Images/Courses/I_SpringHybernate.PNG", "Chad Darby, Popular Java Spring Instructor", "149,000", 0.0, "I"));
			courseRepository.save(new Course("React styled-components v5 (2021 edition)", "https://www.udemy.com/course/react-styled-components/", "./Images/Courses/I_StyledComp1.PNG", "Tom Phillips, Expert Front End Web and Mobile Developer", "22,000", 0.0, "I"));
			courseRepository.save(new Course("Postman: The Complete Guide - REST API Testing", "https://www.udemy.com/course/postman-the-complete-guide/", "./Images/Courses/I_Postman.PNG", "Valentin Despa, Agile Software Developer", "22,000", 0.0, "I"));
		};
	}
}
