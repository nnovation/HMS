package com.example.hms;

public class StudentList {
    String Name;
    String student_id;
    String Hostel_id;
    String Room_number;
    String permanent_address;
    String contact_telephone_number;
    String photograph;
    String room_number;

    public void setPermanent_address(String permanent_address) {
        this.permanent_address = permanent_address;
    }

    public void setContact_telephone_number(String contact_telephone_number) {
        this.contact_telephone_number = contact_telephone_number;
    }

    public void setPhotograph(String photograph) {
        this.photograph = photograph;
    }

    public String getPermanent_address() {
        return permanent_address;
    }

    public String getContact_telephone_number() {
        return contact_telephone_number;
    }

    public String getPhotograph() {
        return photograph;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public void setHostel_id(String hostel_id) {
        Hostel_id = hostel_id;
    }

    public void setRoom_number(String room_number) {
        Room_number = room_number;
    }

    public String getName() {
        return Name;
    }

    public String getStudent_id() {
        return student_id;
    }

    public String getHostel_id() {
        return Hostel_id;
    }

    public String getRoom_number() {
        return Room_number;
    }
}
