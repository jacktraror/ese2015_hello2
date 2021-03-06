package org.sample.controller.service;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.SignupForm;
import org.sample.controller.pojos.TeamSignupForm;
import org.sample.model.Team;

public interface SampleService {

    public SignupForm saveFrom(SignupForm signupForm) throws InvalidUserException;
    
    public TeamSignupForm saveFrom(TeamSignupForm teamSignupForm) throws InvalidUserException;
    
    public Iterable<Team> getTeams();

}
