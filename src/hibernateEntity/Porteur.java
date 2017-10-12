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
	public Porteur (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public Porteur (
		java.lang.Integer _id,
		hibernateEntity.Ligne _ligne,
		java.lang.String _nom) {

		super (
			_id,
			_ligne,
			_nom);
	}
/*[CONSTRUCTOR MARKER END]*/
}