package entite;

import entite.base.BaseLigne;

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
		entite.Localite _localite,
		entite.Type _type,
		java.util.Date _dateCreation,
		java.lang.String _numero,
		java.lang.Integer _etat) {

		super (
			_id,
			_localite,
			_type,
			_dateCreation,
			_numero,
			_etat);
	}
/*[CONSTRUCTOR MARKER END]*/
}