package com.sadi.a2.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.sadi.a2.model.*;
import com.sadi.a2.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	@Autowired
	UserProfileService userProfileService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "welcome";
	}



	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "accessDenied";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

	
	@RequestMapping(value = "/newUser", method = RequestMethod.GET)
	public String newRegistration(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		return "newuser";
	}

	/*
	 * This method will be called on form submission, handling POST request It
	 * also validates the user input
	 */
	@RequestMapping(value = "/newUser", method = RequestMethod.POST)
	public String saveRegistration(@Valid User user,
			BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			System.out.println("There are errors");
			return "newuser";
		}
		userService.save(user);
		
		System.out.println("First Name : "+user.getFirstName());
		System.out.println("Last Name : "+user.getLastName());
		System.out.println("SSO ID : "+user.getSsoId());
		System.out.println("Password : "+user.getPassword());
		System.out.println("Email : "+user.getEmail());
		System.out.println("Checking UsrProfiles....");
		if(user.getUserProfiles()!=null){
			for(UserProfile profile : user.getUserProfiles()){
				System.out.println("Profile : "+ profile.getType());
			}
		}
		
		model.addAttribute("success", "User ");
		return "registrationsuccess";
	}

	
	
	
	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
	
	
	
	@ModelAttribute("roles")
	public List<UserProfile> initializeProfiles() {
		return userProfileService.findAll();
	}

	@RequestMapping(value = {"/quizcomplete"}, method = RequestMethod.GET)
	public String quizcomplete(Model model) {
		return "quiz/quizcomplete";
	}

	// QUIZ TAKER PANEL
	@RequestMapping(value = {"/quiztaker", "/user"}, method = RequestMethod.GET)
	public String quiztakerpanel(Model model) {
		model.addAttribute("user", getPrincipal());
		model.addAttribute("question", new Question());
		model.addAttribute("listQuestions", this.questionService.listQuestions());
		model.addAttribute("quiztype", new QuizType());
		model.addAttribute("listQuizTypes", this.quizTypeService.listQuizTypes());
		model.addAttribute("quizresult", new QuizResult());
		model.addAttribute("listQuizResults", this.quizResultService.listQuizResults());
		return "quiz/quiztaker";

	}


	//CONTROL ACTIVITY ON ADMIN PANEL - CRUD

	//CONTROL ACTIVITY FOR CRUD QUESTIONS - ADMIN PANEL

	private QuestionService questionService;


	@Autowired(required=true)
	@Qualifier(value="questionService")
	public void setQuestionService(QuestionService ps){
		this.questionService = ps;
	}


	//GET QUESTION & QUIZ
	@RequestMapping(value = {"/admin", "/questions", "question"}, method = RequestMethod.GET)
	public String listQuestions(Model model) {
		model.addAttribute("user", getPrincipal());
		model.addAttribute("question", new Question());
		model.addAttribute("listQuestions", this.questionService.listQuestions());
		model.addAttribute("quiztype", new QuizType());
		model.addAttribute("listQuizTypes", this.quizTypeService.listQuizTypes());
		return "quiz/admin";
	}


	//For add and update question both
	@RequestMapping(value= "/question/add", method = RequestMethod.POST)
	public String addQuestion(@ModelAttribute("question") Question q){

		if(q.getId() == 0){
			//new question, add it
			this.questionService.addQuestion(q);
		}else{
			//existing question, call update
			this.questionService.updateQuestion(q);
		}

		return "redirect:/admin";

	}
	//Remove Question
	@RequestMapping("/remove/{id}")
	public String removeQuestion(@PathVariable("id") int id){

		this.questionService.removeQuestion(id);
		return "redirect:/admin";
	}
	//Edit Question
	@RequestMapping("/edit/{id}")
	public String editQuestion(@PathVariable("id") int id, Model model){
		model.addAttribute("question", this.questionService.getQuestionById(id));
		model.addAttribute("listQuestions", this.questionService.listQuestions());
		return "quiz/admin";
	}
	////
	////////////////

	//CONTROL ACTIVITY FOR CRUD QUIZ TYPE - ADMIN PANEL
	private QuizTypeService quizTypeService;

	@Autowired(required=true)
	@Qualifier(value="quizTypeService")
	public void setQuizTypeService(QuizTypeService pt){
		this.quizTypeService = pt;
	}

	//For add and update quiz type both
	@RequestMapping(value= "/quiz/add", method = RequestMethod.POST)
	public String addQuizType(@ModelAttribute("quiztype") QuizType qt){

		if(qt.getId() == 0){
			//new quiz type, add it
			this.quizTypeService.addQuizType(qt);
		}else{
			//existing question, call update
			this.quizTypeService.updateQuizType(qt);
		}

		return "redirect:/admin";

	}
	//Remove Quiz
	@RequestMapping("/removequiz/{id}")
	public String removeQuizType(@PathVariable("id") int id){

		this.quizTypeService.removeQuizType(id);
		return "redirect:/admin";
	}
	//Edit Quiz
	@RequestMapping("/editquiz/{id}")
	public String editQuizType(@PathVariable("id") int id, Model model){
		model.addAttribute("quiztype", this.quizTypeService.getQuizTypeById(id));
		model.addAttribute("listQuizTypes", this.quizTypeService.listQuizTypes());
		return "quiz/admin";
	}

	///////////////////////

	///////////////////////////////////////// QUIZ RESULT /////////////////////////////////

	@Autowired(required=true)
	@Qualifier(value="quizResultService")
	private QuizResultService quizResultService;


	public void setQuizResultService(QuizResultService pr){
		this.quizResultService = pr;
	}

	//For add quiz result
	@RequestMapping(value= "/quizresult/add", method = RequestMethod.POST)
	public String addQuizResult(@ModelAttribute("quizresult") QuizResult qr){


		this.quizResultService.addQuizResult(qr);


		return "redirect:/quizcomplete";

	}






}