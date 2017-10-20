package entity.base;

import java.io.Serializable;


/**
 * This class has been automatically generated by Hibernate Synchronizer.
 * For more information or documentation, visit The Hibernate Synchronizer page
 * at http://www.binamics.com/hibernatesync or contact Joe Hudson at joe@binamics.com.
 *
 * This is an object that contains data related to the ligne table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ligne"
 */
public abstract class BaseLigne  implements Serializable {

	public static String PROP_NUMERO = "Numero";
	public static String PROP_ETAT = "Etat";
	public static String PROP_DATE_CREATION = "DateCreation";
	public static String PROP_LOCALITE = "Localite";
	public static String PROP_FORFAIT = "Forfait";
	public static String PROP_ID = "Id";


	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer _id;

	// fields
	private java.util.Date _dateCreation;
	private java.lang.String _numero;
	private java.lang.Integer _etat;

	// many to one
	private entity.Localite _localite;
	private entity.Forfait _forfait;


	// constructors
	public BaseLigne () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLigne (java.lang.Integer _id) {
		this.setId(_id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseLigne (
		java.lang.Integer _id,
		entity.Localite _localite,
		entity.Forfait _forfait,
		java.util.Date _dateCreation,
		java.lang.String _numero,
		java.lang.Integer _etat) {

		this.setId(_id);
		this.setLocalite(_localite);
		this.setForfait(_forfait);
		this.setDateCreation(_dateCreation);
		this.setNumero(_numero);
		this.setEtat(_etat);
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
	 * Return the value associated with the column: dateCreation
	 */
	public java.util.Date getDateCreation () {
		return _dateCreation;
	}

	/**
	 * Set the value related to the column: dateCreation
	 * @param _dateCreation the dateCreation value
	 */
	public void setDateCreation (java.util.Date _dateCreation) {
		this._dateCreation = _dateCreation;
	}


	/**
	 * Return the value associated with the column: numero
	 */
	public java.lang.String getNumero () {
		return _numero;
	}

	/**
	 * Set the value related to the column: numero
	 * @param _numero the numero value
	 */
	public void setNumero (java.lang.String _numero) {
		this._numero = _numero;
	}


	/**
	 * Return the value associated with the column: etat
	 */
	public java.lang.Integer getEtat () {
		return _etat;
	}

	/**
	 * Set the value related to the column: etat
	 * @param _etat the etat value
	 */
	public void setEtat (java.lang.Integer _etat) {
		this._etat = _etat;
	}


	/**
     * @hibernate.property
     *  column=localite
	 * not-null=true
	 */
	public entity.Localite getLocalite () {
		return this._localite;
	}

	/**
	 * Set the value related to the column: localite
	 * @param _localite the localite value
	 */
	public void setLocalite (entity.Localite _localite) {
		this._localite = _localite;
	}


	/**
     * @hibernate.property
     *  column=forfait
	 * not-null=true
	 */
	public entity.Forfait getForfait () {
		return this._forfait;
	}

	/**
	 * Set the value related to the column: forfait
	 * @param _forfait the forfait value
	 */
	public void setForfait (entity.Forfait _forfait) {
		this._forfait = _forfait;
	}


	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof entity.base.BaseLigne)) return false;
		else {
			entity.base.BaseLigne mObj = (entity.base.BaseLigne) obj;
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