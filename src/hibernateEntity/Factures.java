package hibernateEntity;

import hibernateEntity.base.BaseFactures;

/**
 * This is the object class that relates to the Factures table.
 * Any customizations belong here.
 */
public class Factures extends BaseFactures {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Factures () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Factures (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public Factures (
		java.lang.Integer _id,
		java.lang.String _iDFacture,
		java.lang.Integer _annee,
		java.lang.Integer _mois) {

		super (
			_id,
			_iDFacture,
			_annee,
			_mois);
	}
/*[CONSTRUCTOR MARKER END]*/
}