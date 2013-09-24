/***
 * Copyright (c) 2009 Caelum - www.caelum.com.br/opensource
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.caelum.vraptor.musicjungle.controller;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hsqldb.Session;

import sun.awt.ComponentFactory;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.musicjungle.dao.DefaultUserDao;
import br.com.caelum.vraptor.musicjungle.dao.UserDao;
import br.com.caelum.vraptor.musicjungle.interceptor.Public;
import br.com.caelum.vraptor.musicjungle.interceptor.UserInfo;
import br.com.caelum.vraptor.musicjungle.model.User;
import br.com.caelum.vraptor.validator.ValidationMessage;

/**
 * This class will be responsible to login/logout users.
 * We will use VRaptor URI conventions for this class.
 *
 * For accessing the method doStuff of the class SomethingController,
 * the URI is: /something/doStuff
 *
 */
@Controller
public class HomeController {

    private Result result;
    private Validator validator;
    private UserInfo userInfo;
	private UserDao dao;

	//CDI eyes only
	@Deprecated
	public HomeController() {}

	/**
	 * You can receive any dependency on constructor. If VRaptor knows all dependencies, this
	 * class will be created with no problem. You can use as dependencies:
	 * - all VRaptor components, e.g {@link Result} and {@link Validator}
	 * - all of your classes annotated with @Component, e.g {@link DefaultUserDao}
	 * - all of the classes that have a {@link ComponentFactory}, e.g {@link Session} or {@link SessionFactory}
	 */
	@Inject
	public HomeController(UserDao dao, UserInfo userInfo, Result result, Validator validator) {
	    this.dao = dao;
		this.result = result;
	    this.validator = validator;
        this.userInfo = userInfo;
	}

	/**
	 * Using it only to indicate to vaas that this is the logout method
	 */
	public void logout() {
	}

	/**
	 * Using it only to indicate to vaas that this is the login method
	 */
	public void login() {
	}

	public void loginForm() {
		
	}

}
