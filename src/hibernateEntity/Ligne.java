package hibernateEntity;

import hibernateEntity.base.BaseLigne;

/**
 * This is the object class that relates to the ligne table.
 * Any customizations belong here.
 */
public class Ligne extends BaseLigne {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Ligne () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Ligne (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public Ligne (
		java.lang.Integer _id,
		hibernateEntity.Porteur _numeroLigne) {

		super (
			_id,
			_numeroLigne);
	}

/*[CONSTRUCTOR MARKER END]*/
}