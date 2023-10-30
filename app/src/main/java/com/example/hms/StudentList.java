package com.example.hms;

public class StudentList {
    String Name;
    String student_id;
    String Hostel_id;
    String Room_number;

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
