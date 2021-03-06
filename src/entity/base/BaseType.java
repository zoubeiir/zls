package entity.base;

import java.io.Serializable;


/**
 * This class has been automatically generated by Hibernate Synchronizer.
 * For more information or documentation, visit The Hibernate Synchronizer page
 * at http://www.binamics.com/hibernatesync or contact Joe Hudson at joe@binamics.com.
 *
 * This is an object that contains data related to the type table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="type"
 */
public abstract class BaseType  implements Serializable {

	public static String PROP_COUT = "Cout";
	public static String PROP_ID = "Id";
	public static String PROP_CODE = "Code";
	public static String PROP_LIBELLE = "Libelle";


	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer _id;

	// fields
	private java.lang.String _code;
	private java.lang.Float _cout;
	private java.lang.String _libelle;

	// collections
	private java.util.Set _ligneSet;
	private java.util.Set _liaisonTypeForfaitSet;


	// constructors
	public BaseType () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseType (java.lang.Integer _id) {
		this.setId(_id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseType (
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
	 * Return the value associated with the column: libelle
	 */
	public java.lang.String getLibelle () {
		return _libelle;
	}

	/**
	 * Set the value related to the column: libelle
	 * @param _libelle the libelle value
	 */
	public void setLibelle (java.lang.String _libelle) {
		this._libelle = _libelle;
	}


	/**
	 * Return the value associated with the column: LigneSet
	 */
	public java.util.Set getLigneSet () {
		return this._ligneSet;
	}

	/**
	 * Set the value related to the column: LigneSet
	 * @param _ligneSet the LigneSet value
	 */
	public void setLigneSet (java.util.Set _ligneSet) {
		this._ligneSet = _ligneSet;
	}
	
	public void addToLigneSet (Object obj) {
		if (null == this._ligneSet) this._ligneSet = new java.util.HashSet();
		this._ligneSet.add(obj);
	}



	/**
	 * Return the value associated with the column: LiaisonTypeForfaitSet
	 */
	public java.util.Set getLiaisonTypeForfaitSet () {
		return this._liaisonTypeForfaitSet;
	}

	/**
	 * Set the value related to the column: LiaisonTypeForfaitSet
	 * @param _liaisonTypeForfaitSet the LiaisonTypeForfaitSet value
	 */
	public void setLiaisonTypeForfaitSet (java.util.Set _liaisonTypeForfaitSet) {
		this._liaisonTypeForfaitSet = _liaisonTypeForfaitSet;
	}
	
	public void addToLiaisonTypeForfaitSet (Object obj) {
		if (null == this._liaisonTypeForfaitSet) this._liaisonTypeForfaitSet = new java.util.HashSet();
		this._liaisonTypeForfaitSet.add(obj);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof entity.base.BaseType)) return false;
		else {
			entity.base.BaseType mObj = (entity.base.BaseType) obj;
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