package entite;

import entite.base.BaseLiaisonTypeForfait;

/**
 * This is the object class that relates to the LiaisonTypeForfait table.
 * Any customizations belong here.
 */
public class LiaisonTypeForfait extends BaseLiaisonTypeForfait {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public LiaisonTypeForfait () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public LiaisonTypeForfait (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public LiaisonTypeForfait (
		java.lang.Integer _id,
		entite.Type _type,
		entite.Forfait _forfait) {

		super (
			_id,
			_type,
			_forfait);
	}

/*[CONSTRUCTOR MARKER END]*/
}