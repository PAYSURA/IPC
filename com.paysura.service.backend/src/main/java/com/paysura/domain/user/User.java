package com.paysura.domain.user;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import com.paysura.domain.user.address.Address;
import com.paysura.domain.user.bill.Bill;
import com.paysura.util.type.RelationshipType;

import lombok.Data;

@NodeEntity
@Data
public class User {

	@GraphId
	Long id;

	private String token;

	@Property(name = "SmartContractAdress")
	@Relationship(type = RelationshipType.HAS_A, direction = Relationship.UNDIRECTED)
	private Address scAdresse;

	@Property(name = "bills")
	private List<Bill> bills;

	@Property(name = "IPC")
	private float ipc_values;

	/**
	 * Default constructor.
	 */
	public User() {
		this(new Address(), new ArrayList<Bill>(), 0f);
	}

	/**
	 * Advanced constructor.
	 * 
	 * @param address
	 *            The address entity.
	 * @param bills
	 *            {@link List} of {@link Bill}'s.
	 * @param ipc_values
	 *            The amount of the ipc values.
	 */
	public User(final Address address, final List<Bill> bills, final float ipc_values) {
		this(address, bills, ipc_values, null);
	}

	/**
	 * Advanced constructor.
	 * 
	 * @param adress
	 *            The address entity.
	 * @param bills
	 *            {@link List} of {@link Bill}'s.
	 * @param ipc_values
	 *            The amount of the ipc values.
	 * @param token
	 *            The token.
	 */
	public User(final Address address, final List<Bill> bills, final float ipc_values, final String token) {
		super();
		this.setScAdresse(address);
		this.setBills(bills);
		this.setIpc_values(ipc_values);
		this.setToken(token);
	}
}