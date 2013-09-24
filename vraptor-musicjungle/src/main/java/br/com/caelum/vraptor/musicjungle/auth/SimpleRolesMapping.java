package br.com.caelum.vraptor.musicjungle.auth;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.interceptor.Interceptor;

import br.com.caelum.vraptor.vaas.configurations.RolesMapping;
import static java.util.Arrays.asList;

@ApplicationScoped
@Alternative
@Priority(Interceptor.Priority.APPLICATION)
public class SimpleRolesMapping implements RolesMapping {

	private Map<String, List<String>> map = new HashMap<String, List<String>>();

	{
		map.put("/", asList("administrador"));
		map.put("/users", asList("baiano"));
	}

	@Override
	public Map<String, List<String>> getSimpleRules() {
		return map;
	}

}
