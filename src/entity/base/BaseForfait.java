package entity.base;

import java.io.Serializable;


/**
 * This class has been automatically generated by Hibernate Synchronizer.
 * For more information or documentation, visit The Hibernate Synchronizer page
 * at http://www.binamics.com/hibernatesync or contact Joe Hudson at joe@binamics.com.
 *
 * This is an object that contains data related to the forfait table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="forfait"
 */
public abstract class BaseForfait  implements Serializable {

	public static String PROP_COUT = "Cout";
	public static String PROP_ID = "Id";
	public static String PROP_CODE = "Code";


	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer _id;

	// fields
	private java.lang.String _code;
	private java.lang.Float _cout;

	// collections
	private java.util.Set _typeSet;


	// constructors
	public BaseForfait () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseForfait (java.lang.Integer _id) {
		this.setId(_id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseForfait (
		java.lang.Integer _id,
		java.lang.String _code,
		java.lang.Float _cout) {

		this.setId(_id);
		this.setCode(_code);
		this.setCout(_cout);
		initialize();
	}

	protected void initialize () {}



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="ID"
     */
	public java.lang.Integer getId () {
		return _id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param _id the new ID
	 */
	public void setId (java.lang.Integer _id) {
		this._id = _id;
		this.hashCode = Integer.MIN_VALUE;
	}


	/**
	 * Return the value associated with the column: code
	 */
	public java.lang.String getCode () {
		return _code;
	}

	/**
	 * Set the value related to the column: code
	 * @param _code the code value
	 */
	public void setCode (java.lang.String _code) {
		this._code = _code;
	}


	/**
	 * Return the value associated with the column: cout
	 */
	public java.lang.Float getCout () {
		return _cout;
	}

	/**
	 * Set the value related to the column: cout
	 * @param _cout the cout value
	 */
	public void setCout (java.lang.Float _cout) {
		this._cout = _cout;
	}


	/**
	 * Return the value associated with the column: TypeSet
	 */
	public java.util.Set getTypeSet () {
		return this._typeSet;
	}

	/**
	 * Set the value related to the column: TypeSet
	 * @param _typeSet the TypeSet value
	 */
	public void setTypeSet (java.util.Set _typeSet) {
		this._typeSet = _typeSet;
	}
	
	public void addToTypeSet (Object obj) {
		if (null == this._typeSet) this._typeSet = new java.util.HashSet();
		this._typeSet.add(obj);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof entity.base.BaseForfait)) return false;
		else {
			entity.base.BaseForfait mObj = (entity.base.BaseForfait) obj;
			if (null == this.getId() || null == mObj.getId()) return false;
			else return (this.getId().equals(mObj.getId()));
		}
	}


	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}

}