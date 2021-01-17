package trickery.element.subimpl;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import trickery.element.IElementSubimpl;

public class SuperimplPolicy {
	public static final SuperimplPolicy NONE = new SuperimplPolicy(Collections.emptyList());;

	List<Class<? extends IElementSubimpl>> tbinstalled;
	public SuperimplPolicy(List<Class<? extends IElementSubimpl>> tbinstalled) {
		this.tbinstalled = tbinstalled;
	}
	
	public List<Class<? extends IElementSubimpl>> toBeInstalled() {
		return this.tbinstalled;
	}
	
	/**
	 * Returns a list of all superclasses and superinterfaces for a given class
	 * Credit to amit at https://stackoverflow.com/questions/9881710/getting-superinterfaces-in-java
	 * @return
	 * The superclasses and superinterfaces, excluding the original class c.
	 */
	public static Set<Class<?>> findAllSuperClasses(Class<?> cl) {
		Queue<Class<?>> queue = new LinkedList<Class<?>>();
		Set<Class<?>> types =new HashSet<Class<?>>();
		queue.add(cl);
		types.add(cl);
		    //BFS:
		while (queue.isEmpty() == false) {
		    Class<?> curr = queue.poll();
		    Class<?>[] supers = curr.getInterfaces();
		    for (Class<?> next : supers) {
		        if (next != null && types.contains(next) == false) {
		            types.add(next);
		            queue.add(next);
		        }
		    }
		    Class<?> next = curr.getSuperclass();
		    if (next != null && types.contains(next) == false) {
		        queue.add(next);
		        types.add(next);
		    }
		}
		return types;
	}
}
