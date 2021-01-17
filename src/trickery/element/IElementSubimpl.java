package trickery.element;

import trickery.element.subimpl.SuperimplPolicy;

/**
 * The purpose of IElementSubimpl is to permit multiple inheritance structures.
 * For instance, ToolboxImpl extends IElementSubimpl.
 * Then, ToolboxImpl can get attached to an element, as well as any other
 * @author phlaxyr
 *
 */
public interface IElementSubimpl {
	/**
	 * Overrides methods in the parent
	 * 
	 * @param parent
	 */
	void __do_overrides__(Element parent);
	
	/**
	 * Declare super implementations for the parent
	 * For instance, if you have a Subimpl called Lion
	 * Animal -> Feline -> Lion
	 * The SuperimplReference must contain information on whether you wish to install
	 * Animal.class or Feline.class.
	 * (Lion.class is automatically installed.)
	 * 
	 * What you want to do is create a single global reference for each type
	 * ie. one SuperimplReference for Lion.class
	 * and reuse it everytime you create a Lion.class
	 * by passing a pointer to your original global reference.
	 * 
	 * TODO: attach example.
	 * @param parent
	 */
	default SuperimplPolicy __get_superimpl__(Element parent) {
		 return SuperimplPolicy.NONE;
	}
	
	/**
	 * After the constructor, The ISubimpl gets passed the parent element to finish initialization
	 * This is a function because constructors can't get defined in interfaces
	 * @param e
	 */
	default void __finish_initialization__(Element e) {
		
	}
}
