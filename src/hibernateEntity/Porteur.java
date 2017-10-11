package hibernateEntity;

import hibernateEntity.base.BasePorteur;

/**
 * This is the object class that relates to the porteur table.
 * Any customizations belong here.
 */
public class Porteur extends BasePorteur {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Porteur () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Porteur (java.lang.String _ligne) {
		super(_ligne);
	}

	/**
	 * Constructor for required fields
	 */
	public Porteur (
		java.lang.String _ligne,
		java.lang.Integer _id,
		java.lang.String _nom) {

		super (
			_ligne,
			_id,
			_nom);
	}
/*[CONSTRUCTOR MARKER END]*/
}