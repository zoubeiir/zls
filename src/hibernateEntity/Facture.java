package hibernateEntity;

import hibernateEntity.base.BaseFacture;

/**
 * This is the object class that relates to the facture table.
 * Any customizations belong here.
 */
public class Facture extends BaseFacture {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Facture () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Facture (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public Facture (
		java.lang.Integer _id,
		hibernateEntity.Ligne _ligne,
		java.lang.String _idFacture,
		java.lang.String _annee,
		java.lang.Float _frais,
		java.lang.String _mois) {

		super (
			_id,
			_ligne,
			_idFacture,
			_annee,
			_frais,
			_mois);
	}

/*[CONSTRUCTOR MARKER END]*/
}