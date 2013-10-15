package br.com.caelum.vraptor.musicjungle;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
import br.com.caelum.vraptor.test.VRaptorIntegration;
import br.com.caelum.vraptor.test.VRaptorTestResult;
import br.com.caelum.vraptor.test.http.Parameters;
import br.com.caelum.vraptor.test.requestflow.UserFlow;

public class ManipulateMusicsTest extends VRaptorIntegration {

	private static Parameters newUserParam = Parameters.initWith("user.name", "emma").add("user.login", "emma")
			.add("user.password", "password");
	private Parameters loginParam = Parameters.initWith("login", "emma").add("password", "password");
	private UserFlow loggedUserFlow;
	private String musicTitle = "the fool on the hill";
	private Parameters newMusic = Parameters.initWith("music.title", musicTitle)
			.add("music.description", "from the beatles")
			.add("music.type", "ROCK");
	
	
	@BeforeClass
	public static void setupClass() {
		navigate().post("/users", newUserParam).execute();
	}
	
	@Before
	public void setup() {
		loggedUserFlow = navigate().post("/home/login", loginParam);
	}

	@Test
	public void shouldBeAbleToCreateANewMusic() {
		String html = loggedUserFlow.post("/musics", newMusic).followRedirect()
			.execute().isValid().wasStatus(200).getResponseBody();
		html.contains(musicTitle + " music added");
	}
	
	@Test
	public void shouldNotBeAbleToCreateAMusicUnlogged() {
		VRaptorTestResult result = navigate().post("/musics", newMusic).execute();
		assertEquals("/home/login", result.getLastPath());
	}
	
	@Test
	public void shouldNotBeAbleToCreateAInvalidMusic() {
		navigate().post("/musics", new Parameters()).execute().isInvalid();
	}
	
}
