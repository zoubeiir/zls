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
		java.lang.String _code,
		java.lang.Float _cout) {

		super (
			_id,
			_code,
			_cout);
	}

/*[CONSTRUCTOR MARKER END]*/
}