package br.com.caelum.vraptor.musicjungle;

import org.junit.Test;

import static org.junit.Assert.*;

import br.com.caelum.vraptor.test.VRaptorIntegration;
import br.com.caelum.vraptor.test.VRaptorTestResult;
import br.com.caelum.vraptor.test.http.Parameters;

public class LoginFlowTest extends VRaptorIntegration {

	private Parameters newUserParam = Parameters.initWith("user.name", "jonh").add("user.login", "jonhdoe")
			.add("user.password", "password");
	private Parameters loginParam = Parameters.initWith("login", "jonhdoe").add("password", "password");

	@Test
	public void shouldBeAbleToCreateNewUser() {
		VRaptorTestResult execution = navigate().post("/users", newUserParam).post("/home/login", loginParam)
				.followRedirect().execute();
		String jsp = execution.getResponseBody();
		assertTrue(jsp.contains("<h1>jonh:"));
	}
}
