package br.com.caelum.vraptor.interceptor;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.cache.VRaptorCache;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.core.Converters;


@Intercepts
public class DoNothingInterceptor {

	@AroundCall
	public void around(SimpleInterceptorStack interceptorStack, Result result,Validator validator,Converters converters,ControllerMethod controllerMethod) {
		interceptorStack.next();
	}
	
	@Accepts
	public boolean accepts(VRaptorCache<String,String> cache,Result result, Validator validator) {
		return true;
	}
}
