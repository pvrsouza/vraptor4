package br.com.caelum.vraptor.events;

import br.com.caelum.vraptor.controller.ControllerMethod;

public class EndOfInterceptorStack {

	private ControllerMethod controllerMethod;
	private Object controllerInstance;

	public EndOfInterceptorStack(ControllerMethod controllerMethod, Object controllerInstance) {
		this.controllerMethod = controllerMethod;
		this.controllerInstance = controllerInstance;
	}
	
	public ControllerMethod getControllerMethod() {
		return controllerMethod;
	}
	
	public Object getControllerInstance() {
		return controllerInstance;
	}
}