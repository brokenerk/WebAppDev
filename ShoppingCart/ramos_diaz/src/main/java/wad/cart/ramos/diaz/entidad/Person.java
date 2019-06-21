package wad.cart.ramos.diaz.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
	@Id
	@SequenceGenerator(name = "person_id_person_seq", sequenceName = "person_id_person_seq", allocationSize = 1)
	@GeneratedValue(generator = "person_id_person_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_person")
	protected Integer id;
	@Column(name = "tx_first_name")
	protected String name;
	@Column(name = "tx_last_name_a")
	protected String lastName;
	@Column(name = "tx_last_name_b")
	protected String secondLastName;
	@Column(name = "tx_street")
	private String street;
	@Column(name = "tx_city")
	private String city;
	@Column(name = "tx_state")
	private String state;
	@Column(name = "tx_zipcode")
	private String zipCode;
	@Column(name = "tx_telephone")
	private String telephone;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Validations(
			requiredStrings = {@RequiredStringValidator(fieldName = "model.name", type = ValidatorType.FIELD, message = "Name is mandatory")}, 
			stringLengthFields = {@StringLengthFieldValidator(fieldName = "model.name", type = ValidatorType.FIELD, message = "Name length is too long. Max is 30", maxLength = "30")})
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Validations(
			requiredStrings = {@RequiredStringValidator(fieldName = "model.lastName", type = ValidatorType.FIELD, message = "Last name is mandatory")}, 
			stringLengthFields = {@StringLengthFieldValidator(fieldName = "model.lastName", type = ValidatorType.FIELD, message = "Last name length is too long. Max is 30", maxLength = "30")})
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Validations(
			requiredStrings = {@RequiredStringValidator(fieldName = "model.secondLastName", type = ValidatorType.FIELD, message = "Second lastname is mandatory")}, 
			stringLengthFields = {@StringLengthFieldValidator(fieldName = "model.secondLastName", type = ValidatorType.FIELD, message = "Second lastname length is too long. Max is 30", maxLength = "30")})
	public String getSecondLastName() {
		return secondLastName;
	}

	public void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
	}

	@Validations(
			requiredStrings = {@RequiredStringValidator(fieldName = "model.state", type = ValidatorType.FIELD, message = "State is mandatory")}, 
			stringLengthFields = {@StringLengthFieldValidator(fieldName = "model.state", type = ValidatorType.FIELD, message = "State length is too long. Max is 100", maxLength = "100")})
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	@Validations(
			requiredStrings = {@RequiredStringValidator(fieldName = "model.telephone", type = ValidatorType.FIELD, message = "Telephone is mandatory")}, 
			stringLengthFields = {@StringLengthFieldValidator(fieldName = "model.telephone", type = ValidatorType.FIELD, message = "Telephone length must be 10. Between every two numbers there must be a -", minLength="14", maxLength = "14")})
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	@Validations(
			requiredStrings = {@RequiredStringValidator(fieldName = "model.street", type = ValidatorType.FIELD, message = "Street is mandatory")}, 
			stringLengthFields = {@StringLengthFieldValidator(fieldName = "model.street", type = ValidatorType.FIELD, message = "Street length is too long. Max is 100", maxLength = "100")})
	public String getStreet() {
		return street;
	}
	
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	@Validations(
			requiredStrings = {@RequiredStringValidator(fieldName = "model.city", type = ValidatorType.FIELD, message = "City is mandatory")}, 
			stringLengthFields = {@StringLengthFieldValidator(fieldName = "model.city", type = ValidatorType.FIELD, message = "City length is too long. Max is 100", maxLength = "100")})
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@Validations(
			requiredStrings = {@RequiredStringValidator(fieldName = "model.zipCode", type = ValidatorType.FIELD, message = "ZipCode is mandatory")}, 
			stringLengthFields = {@StringLengthFieldValidator(fieldName = "model.zipCode", type = ValidatorType.FIELD, message = "ZipCode length must be 5", minLength="5", maxLength = "5")})
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
