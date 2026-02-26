package model;

public class Guest {

    String guest_name;
    int roon_no;
    String contact_no;

    public Guest() {}

    public Guest(String guest_name, int roon_no, String contact_no) {
        this.guest_name = guest_name;
        this.roon_no = roon_no;
        this.contact_no = contact_no;
    }

    public String getGuest_name() {
        return guest_name;
    }

    public void setGuest_name(String guest_name) {
        this.guest_name = guest_name;
    }

    public int getRoon_no() {
        return roon_no;
    }

    public void setRoon_no(int roon_no) {
        this.roon_no = roon_no;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

}
