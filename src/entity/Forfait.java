package entity;

import entity.base.BaseForfait;

/**
 * This is the object class that relates to the forfait table.
 * Any customizations belong here.
 */
public class Forfait extends BaseForfait {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Forfait () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Forfait (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public Forfait (
		java.lang.Integer _id,
		entity.Type _type) {

		super (
			_id,
			_type);
	}
/*[CONSTRUCTOR MARKER END]*/
}