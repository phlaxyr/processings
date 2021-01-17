package trickery.element.funcs;

public interface ITrickeryLambda {
	default String stackTrace() {
		return this.getClass().toGenericString();
	}
}
