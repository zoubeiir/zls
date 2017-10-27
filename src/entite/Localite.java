package entite;

import entite.base.BaseLocalite;

/**
 * This is the object class that relates to the localite table.
 * Any customizations belong here.
 */
public class Localite extends BaseLocalite {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Localite () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Localite (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public Localite (
		java.lang.Integer _id,
		java.lang.String _code) {

		super (
			_id,
			_code);
	}

/*[CONSTRUCTOR MARKER END]*/
}