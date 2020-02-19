package com.parking.dao;

import java.sql.*;
import java.util.*;

import com.parking.dto.Client;

public class ClientDao {

	/*
	 * Llista tots els clients de la base de dades
	 * 
	 */
	public List<Client> listar() {
		String SQL_SELECT = "SELECT cli_id, cli_name, cli_surname, cli_email, cli_phone " + " FROM client";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Client client = null;
		List<Client> clients = new ArrayList<>();
		
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("cli_id");
				String name = rs.getString("cli_name");
				String surname = rs.getString("cli_surname");
				String email = rs.getString("cli_email");
				String phone = rs.getString("cli_phone");

				client = new Client(id, name, surname, email, phone);
				clients.add(client);
			}
		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(rs);
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return clients;
	}

	/*
	 * Recupera un client a la base de dades segons el seu ID
	 * 
	 */
	public Client findById(Client client) {
		String SQL_SELECT_BY_ID = "SELECT cli_id, cli_name, cli_surname, cli_email, cli_phone"
				+ " FROM client WHERE cli_id = ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_BY_ID);

			stmt.setInt(1, client.getId());
			rs = stmt.executeQuery();
			rs.absolute(1);// nos posicionamos en el primer registro devuelto

			String name = rs.getString("cli_name");
			String surname = rs.getString("cli_surname");
			String email = rs.getString("cli_email");
			String phone = rs.getString("cli_phone");
			

			client.setName(name);
			client.setSurname(surname);
			client.setEmail(email);
			client.setPhone(phone);
		

		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(rs);
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return client;
	}

	/*
	 * Crea un client a la base de dades
	 * 
	 */
	public int create(Client client) {
		String SQL_INSERT = "INSERT INTO client(cli_name, cli_surname, cli_email, cli_phone) "
				+ " VALUES(?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, client.getName());
			stmt.setString(2, client.getSurname());
			stmt.setString(3, client.getEmail());
			stmt.setString(4, client.getPhone());
		
System.out.println(client.toString());
			rows = stmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return rows;
	}

	/*
	 * Modifica un client de la base de dades
	 * 
	 */
	public int update(Client client) {
		String SQL_UPDATE = "UPDATE client "
				+ " SET cli_name=?, cli_surname=?, cli_email=?, cli_phone=? WHERE cli_id=?";
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			int i = 1;
			stmt.setString(i++, client.getName());
			stmt.setString(i++, client.getSurname());
			stmt.setString(i++, client.getEmail());
			stmt.setString(i++, client.getPhone());
			stmt.setInt(i++, client.getId());

			rows = stmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return rows;
	}

	/*
	 * Esborra un client de la base de dades
	 * 
	 */
	public int delete(Client client) {
		String SQL_DELETE = "DELETE FROM client WHERE cli_id = ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, client.getId());
			rows = stmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return rows;
	}

}
