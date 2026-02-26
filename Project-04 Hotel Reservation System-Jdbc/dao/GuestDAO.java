package dao;

import db.DBConnection;
import model.Guest;
import java.sql.*;

public class GuestDAO {

    Connection con = DBConnection.getConnection();

    public void addGuest(Guest guest) {

        try {

            String sql = "INSERT INTO reservations(guest_name, room_no, contact) VALUES (?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, guest.getGuest_name());
            ps.setInt(2,guest.getRoon_no());
            ps.setString(3, guest.getContact_no());

            ps.executeUpdate();

            System.out.println("Guest added successfully");

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public void viewReservations(){

        try{

            String sql = "SELECT * FROM reservations";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            boolean hasData = false;
            while(rs.next()){

                hasData = true;
                System.out.println("Reservation No: " + rs.getInt(1) + " | Guest Name: "
                        + rs.getString(2) + " | Room No: " + rs.getInt(3) + " | Contact NO: "
                        + rs.getString(4) + " | Date of Reservation: " + rs.getTimestamp(5));

            }

            if(!hasData){
                System.out.println("No reservations found");
            }

        } catch (Exception e){

            e.printStackTrace();

        }
    }

    public void getRoomNo(int id){

        try{

            String sql = "SELECT room_no,guest_name FROM reservations WHERE reservation_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                System.out.println("Room no: "+rs.getInt(1)+" "+ "Guest_name: " + rs.getString(2));
            }

        }catch(Exception e){

            e.printStackTrace();

        }
    }

    public void updateReservations(int id, Guest guest){

        try{

            String sql = "UPDATE reservations SET guest_name = ?,room_no = ?,contact = ? WHERE reservation_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, guest.getGuest_name());
            ps.setInt(2,guest.getRoon_no());
            ps.setString(3, guest.getContact_no());
            ps.setInt(4,id);

            ps.executeUpdate();

            System.out.println("Guest updated successfully");

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    public void deleteReservations(int id){
        try{
            String sql = "DELETE FROM reservations WHERE reservation_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Guest deleted successfully");

        }catch(Exception e){

            e.printStackTrace();

        }
    }
}
