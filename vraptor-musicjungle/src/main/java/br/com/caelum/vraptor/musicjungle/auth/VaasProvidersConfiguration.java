package br.com.caelum.vraptor.musicjungle.auth;

import javax.enterprise.context.ApplicationScoped;

import br.com.caelum.vraptor.vaas.ProviderConfiguration;
import br.com.caelum.vraptor.vaas.authentication.AuthProvider;
import br.com.caelum.vraptor.vaas.authentication.JAASProvider;

@ApplicationScoped
public class VaasProvidersConfiguration implements ProviderConfiguration{

	@Override
	public Class<? extends AuthProvider>[] providers() {
		return new Class[]{JAASProvider.class};
	}

	
}
