package org.sample.controller;

import javax.validation.Valid;

import org.sample.controller.exceptions.InvalidTeamException;
import org.sample.controller.pojos.TeamSignupForm;
import org.sample.controller.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class NewTeamController {
	
	//------------------------------- zum Testen
	String teamName;
	long date;
	
	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
    public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}
	//--------------------------------------------

	@Autowired
    SampleService sampleService;


    @RequestMapping(value = "/newTeam", method = RequestMethod.GET)
    public ModelAndView index() {
    	ModelAndView model = new ModelAndView("new-team");
    	model.addObject("teamSignupForm", new TeamSignupForm());    	
        return model;
    }

    @RequestMapping(value = "/teamSignupForm", method = RequestMethod.POST)
    public ModelAndView create(@Valid TeamSignupForm teamSignupForm, BindingResult result, RedirectAttributes redirectAttributes) {
    	ModelAndView model;    	
    	if (!result.hasErrors()) {
            try {
            	sampleService.saveFrom(teamSignupForm);
            	model = new ModelAndView("show");
            } catch (InvalidTeamException e) {
            	model = new ModelAndView("new-team");
            	model.addObject("page_error", e.getMessage());
            }
        } else {
        	model = new ModelAndView("new-team");
        }   	
    	return model;
    }

}