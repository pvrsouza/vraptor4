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
package br.com.caelum.vraptor.core;

import static com.google.common.base.Preconditions.checkArgument;

import javax.enterprise.context.RequestScoped;

import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.http.Parameter;
import br.com.caelum.vraptor.http.ValuedParameter;

/**
 * Holder for method being invoked and parameters being passed.
 * 
 * @author Guilherme Silveira
 * @author Fabio Kung
 */
@RequestScoped
public class MethodInfo {

	private final ControllerMethod controllerMethod;
	private ValuedParameter[] valuedParameters;
	private Object result;
	

	public MethodInfo(ControllerMethod controllerMethod, Parameter[] parameters) {
		this.controllerMethod = controllerMethod;

		// FIXME to ugly
		valuedParameters = new ValuedParameter[parameters.length];
		for (int i = 0; i < parameters.length; i++)
			valuedParameters[i] = new ValuedParameter(parameters[i], null);
	}

	public ControllerMethod getControllerMethod() {
		return controllerMethod;
	}

	public void setParameterValues(Object[] parameters) {
		checkArgument(parameters.length == valuedParameters.length, "Parameter values must have length={}",
				valuedParameters.length);
		for (int i = 0; i < valuedParameters.length; i++) {
			valuedParameters[i].setValue(parameters[i]);
		}
	}

	public Object[] getParameterValues() {
		Object[] parameters = new Object[valuedParameters.length];

		for (int i = 0; i < valuedParameters.length; i++) {
			parameters[i] = valuedParameters[i].getValue();
		}

		return parameters;
	}

	public Parameter[] getParameters() {
		Parameter[] parameters = new Parameter[valuedParameters.length];

		for (int i = 0; i < valuedParameters.length; i++) {
			parameters[i] = valuedParameters[i].getParameter();
		}

		return parameters;
	}

	public void setValuedParameters(ValuedParameter[] valuedParameters) {
		this.valuedParameters = valuedParameters;
	}

	public ValuedParameter[] getValuedParameters() {
		return valuedParameters;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
}
