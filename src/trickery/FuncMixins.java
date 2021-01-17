package trickery;

import java.util.Arrays;

public interface FuncMixins {
	default String str(Object o) {
		if(o.getClass().isArray()) {
			return Arrays.deepToString((Object[]) o);
		}
		else return o.toString();
	}
	default void print(Object o, String end) {
		System.out.print(str(o) + end);
	}
	default void print(Object o) {
		print(o, "\n");
	}
}
