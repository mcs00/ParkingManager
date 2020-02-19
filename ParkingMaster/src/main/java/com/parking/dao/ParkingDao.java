package com.parking.dao;

import com.parking.dto.Parking;
import com.parking.enums.ParkingTypes.ParkingTypes;

import java.sql.*;
import java.util.*;

public class ParkingDao {
    public List<Parking> listar() {
        String SQL_SELECT = "SELECT par_id, par_name, par_type, par_pricePerMinute " + " FROM parking";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Parking parking;
        List<Parking> parking = new ArrayList<>();

        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("par_id");
                String name = rs.getString("par_name");
                ParkingTypes type = ParkingTypes.valueOf(rs.getString("par_type"));
                double price = rs.getDouble("par_pricePerMinute");

                parking = new Parking(id, name, type, price);
                parking.add(parking);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            DBConnection.close(rs);
            DBConnection.close(stmt);
            DBConnection.close(conn);
        }
        return parking;
    }

    public Parking findById(Parking parking) {
        String SQL_SELECT_BY_ID = "SELECT par_id, par_name, par_type, par_pricePerMinute "
                + " FROM parking WHERE par_id = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);

            stmt.setInt(1, parking.getId());
            rs = stmt.executeQuery();
            rs.absolute(1);// nos posicionamos en el primer registro devuelto

            int id = rs.getInt("par_id");
            String name = rs.getString("par_name");
            ParkingTypes type = ParkingTypes.valueOf(rs.getString("par_type"));
            double price = rs.getDouble("par_pricePerMinute");

            parking.setId(id);
            parking.setName(name);
            parking.setType(type);
            parking.setPricePerMinute(price);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            DBConnection.close(rs);
            DBConnection.close(stmt);
            DBConnection.close(conn);
        }
        return parking;
    }


    public int create(Parking parking) {
        String SQL_INSERT = "INSERT INTO parking(par_id, par_name, par_type, par_pricePerMinute) "
                + " VALUES(?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, parking.getId());
            stmt.setString(2, parking.getName());
            stmt.setString(3, parking.getType().toString());
            stmt.setDouble(4, parking.getPricePerMinute());
            System.out.println(parking.toString());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            DBConnection.close(stmt);
            DBConnection.close(conn);
        }
        return rows;
    }

    public int update(Parking parking) {
        String SQL_UPDATE = "UPDATE parking "
                + " SET par_name=?, par_type=?, par_pricePerMinute=? WHERE par_id=?";
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            int i = 1;
            stmt.setString(i++, parking.getName());
            stmt.setString(i++, parking.getType().toString());
            stmt.setDouble(i++, parking.getPricePerMinute());
            stmt.setInt(i++, parking.getId());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            DBConnection.close(stmt);
            DBConnection.close(conn);
        }
        return rows;
    }

    public int delete(Parking parking) {
        String SQL_DELETE = "DELETE FROM parking WHERE par_id = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, parking.getId());
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
