package com.HotelBook.Book.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class RoomValidatorDTO {

    @Id
    private int OdaID;
    private String RoomStatus;

    public int getOdaID() {
        return OdaID;
    }

    public void setOdaID(int odaID) {
        OdaID = odaID;
    }

    public String getRoomStatus() {
        return RoomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        RoomStatus = roomStatus;
    }
}
