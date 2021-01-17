package trickery.element;

import java.util.HashMap;

public class DeepDictionary {
	
	private HashMap<Class<? extends Object>, HashMap<String, Object>> typedvarmap;
//	public <F> F g(String key, String type)
	
	public <F> F g(String key, Class<F> type) {
		return this.get(key, type);
	}
	@SuppressWarnings("unchecked")
	public <F> F get(String key, Class<F> type) {
		HashMap<String, Object> varmap = typedvarmap.getOrDefault(type, null);
		if(varmap == null) return null;
		return (F) varmap.getOrDefault(key, null); 
	}
	
	public <F> void s(String key, F f, Class<F> type) {
		this.set(key, f, type);
	}
	public <F> void set(String key, F f, Class<F> type) {
		HashMap<String, Object> varmap = typedvarmap.getOrDefault(type, null);
		if(varmap == null) {
			varmap = new HashMap<String, Object>();
			typedvarmap.put(type, varmap);
		}
		varmap.put(key, f); // pointers permit this
	}
	
	public <F> void s(String key, F f) {
		this.set(key, f);
	} 
	public <F> void set(String key, F f) {
		Class<? extends Object> type = f.getClass();
		HashMap<String, Object> varmap = typedvarmap.getOrDefault(type, null);
		if(varmap == null) {
			varmap = new HashMap<String, Object>();
			typedvarmap.put(type, varmap);
		}
		varmap.put(key, f); // pointers permit this
	}
}
