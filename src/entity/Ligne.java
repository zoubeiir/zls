package entity;

import entity.base.BaseLigne;

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
		entity.Localite _localite,
		entity.Forfait _forfait,
		java.util.Date _dateCreation,
		java.lang.String _numero,
		java.lang.Integer _etat) {

		super (
			_id,
			_localite,
			_forfait,
			_dateCreation,
			_numero,
			_etat);
	}
/*[CONSTRUCTOR MARKER END]*/
}