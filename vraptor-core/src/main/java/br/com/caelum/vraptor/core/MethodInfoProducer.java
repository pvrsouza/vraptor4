package br.com.caelum.vraptor.core;

import java.lang.reflect.Method;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;

import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.controller.DefaultControllerMethod;
import br.com.caelum.vraptor.http.Parameter;
import br.com.caelum.vraptor.http.ParameterNameProvider;

public class MethodInfoProducer {

	@Inject
	private ParameterNameProvider parameterNameProvider;

	@Produces
	@RequestScoped
	public MethodInfo createMethodInfo(InjectionPoint ip) {
		Method method = (Method) ip.getMember();
		ControllerMethod c = DefaultControllerMethod.instanceFor(method.getDeclaringClass(), method);

		Parameter[] parametersFor = parameterNameProvider.parametersFor(method);
		return new MethodInfo(c, parametersFor);
	}
}
