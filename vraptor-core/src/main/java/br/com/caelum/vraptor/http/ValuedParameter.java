package br.com.caelum.vraptor.http;

public class ValuedParameter {

	private final Parameter parameter;
	private Object value;

	public ValuedParameter(Parameter parameter, Object value) {
		this.parameter = parameter;
		this.value = value;
	}

	public Parameter getParameter() {
		return parameter;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
