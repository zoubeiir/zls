package entity;

import entity.base.BaseType;

/**
 * This is the object class that relates to the type table.
 * Any customizations belong here.
 */
public class Type extends BaseType {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Type () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Type (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public Type (
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