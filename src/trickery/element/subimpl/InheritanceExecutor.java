package trickery.element.subimpl;

public class InheritanceExecutor {
	
	/**
	 * This function/class is a central manager controller for managing inheritance stuff
	 * Gets the implementation under which the element is using and which is actively installed in the element
	 * For instance, if you have a Subimpl called Lion
	 * Animal -> Feline -> Lion
	 * Where
	 * parent.install(this, Lion.class)
	 * 
	 * getActiveImplementationOf(parent, Animal.class) should return -> Lion.class
	 * Lion.class is the one that is actually installed
	 * and which is not installed "weak"
	 * whereas the other ones are not actually truly nominally installed
	 * but they are only available through inheritance
	 * (this class is designed to provide that inheritance functionality)
	 * and as such
	 * parent.getComputedSubimpl(Animal.class) should return -> an instance of LionSubimpl.
	 * Because since LionSubimpl extends Animal it's all fine and dandy
	 * and parent.getComputedSubimpl(Animal.class) -> Animal
	 * 
	 * The problem arises with multi-inheritance
	 * Which is exactly the problem that the Trickery classes are intended to solve - 
	 * a way of handling multiple inheritances, state-permitting.
	 * In this case, this class ("interpreter", if you will) will try to resolve the conflict
	 * using a combination of deferrals and priorities (which must be set by the user)
	 * but will throw an exception if there seems to exist ambiguities or hard-to-predict behaviors
	 * 
	 * 
	 * @param parent
	 */
	public Class<?> getActiveImplementationOf(Class<?> c) {
		return null; // TODO
		
	}
}	
