package entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "rooms", schema = "dbo", catalog = "choresdb")
@NamedQuery(name = "Room.orderByName", query = "SELECT tbl FROM Room tbl ORDER BY tbl.roomName")
public class Room {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "room_id")
    private int roomId;
    @Basic
    @Column(name = "room_name")
    private String roomName;
    @Basic
    @Column(name = "room_description")
    private String roomDescription;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (roomId != room.roomId) return false;
        if (roomName != null ? !roomName.equals(room.roomName) : room.roomName != null) return false;
        if (roomDescription != null ? !roomDescription.equals(room.roomDescription) : room.roomDescription != null)
            return false;

        return true;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @Override
    public int hashCode() {
        int result = roomId;
        result = 31 * result + (roomName != null ? roomName.hashCode() : 0);
        result = 31 * result + (roomDescription != null ? roomDescription.hashCode() : 0);
        return result;
    }
}
