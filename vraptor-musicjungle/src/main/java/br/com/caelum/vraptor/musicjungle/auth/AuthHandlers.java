package br.com.caelum.vraptor.musicjungle.auth;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.musicjungle.controller.HomeController;
import br.com.caelum.vraptor.musicjungle.controller.UsersController;
import br.com.caelum.vraptor.musicjungle.dao.UserDao;
import br.com.caelum.vraptor.musicjungle.interceptor.UserInfo;
import br.com.caelum.vraptor.musicjungle.model.User;
import br.com.caelum.vraptor.vaas.event.AuthenticateFailedEvent;
import br.com.caelum.vraptor.vaas.event.AuthenticatedEvent;
import br.com.caelum.vraptor.vaas.event.AuthorizationFailedEvent;
import br.com.caelum.vraptor.vaas.event.LogoutEvent;
import br.com.caelum.vraptor.vaas.event.RefreshUserEvent;

@RequestScoped
public class AuthHandlers {

	@Inject
	private Result result;
	@Inject
	private UserInfo userInfo;
	@Inject
	private UserDao userDao;

	public void handle(@Observes AuthenticatedEvent event){
		User user = userDao.find(event.getUserPrincipal().getName());
		userInfo.login(user);
		result.redirectTo(UsersController.class).home();
	}
	
	public void handle(@Observes RefreshUserEvent userEvent){
		userDao.refresh(userInfo.getUser());
	}

	public void handle(@Observes AuthenticateFailedEvent event){
		result.redirectTo(HomeController.class).loginForm();
	}

	public void handle(@Observes AuthorizationFailedEvent event){		
		result.redirectTo(HomeController.class).loginForm();
	}
	
	public void handle(@Observes LogoutEvent event){
		result.redirectTo(HomeController.class).loginForm();
	}

}
