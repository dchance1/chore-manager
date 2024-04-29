package entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "chores", schema = "dbo", catalog = "choresdb")
@org.hibernate.annotations.Entity(
        dynamicInsert = true
)
public class Chore {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "chore_id")
    private int choreId;
    @Basic
    @Column(name = "user_id")
    private Integer userId;
    @Basic
    @Column(name = "chore_type_id")
    private Integer choreTypeId;
    @Basic
    @Column(name = "room_id")
    private Integer roomId;
    @Basic
    @Column(name = "status")
    private String status;
    @Basic
    @Column(name = "isActive")
    private Byte isActive;
    @Basic
    @Column(name = "created_at")
    private Date createdAt;
    @Basic
    @Column(name = "date_completed")
    private Date dateCompleted;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id",insertable=false, updatable=false)
    private User usersByUserId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id",insertable=false, updatable=false)
    private User usersByUserId_0;
    @ManyToOne
    @JoinColumn(name = "chore_type_id", referencedColumnName = "chore_type_id",insertable=false, updatable=false)
    private ChoreType choreTypesByChoreTypeId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chore chore = (Chore) o;

        if (choreId != chore.choreId) return false;
        if (userId != null ? !userId.equals(chore.userId) : chore.userId != null) return false;
        if (choreTypeId != null ? !choreTypeId.equals(chore.choreTypeId) : chore.choreTypeId != null) return false;
        if (roomId != null ? !roomId.equals(chore.roomId) : chore.roomId != null) return false;
        if (status != null ? !status.equals(chore.status) : chore.status != null) return false;
        if (isActive != null ? !isActive.equals(chore.isActive) : chore.isActive != null) return false;
        if (createdAt != null ? !createdAt.equals(chore.createdAt) : chore.createdAt != null) return false;
        if (dateCompleted != null ? !dateCompleted.equals(chore.dateCompleted) : chore.dateCompleted != null)
            return false;

        return true;
    }

    public int getChoreId() {
        return choreId;
    }

    public void setChoreId(int choreId) {
        this.choreId = choreId;
    }

    public Integer getChoreTypeId() {
        return choreTypeId;
    }

    public void setChoreTypeId(Integer choreTypeId) {
        this.choreTypeId = choreTypeId;
    }

    public ChoreType getChoreTypesByChoreTypeId() {
        return choreTypesByChoreTypeId;
    }

    public void setChoreTypesByChoreTypeId(ChoreType choreTypesByChoreTypeId) {
        this.choreTypesByChoreTypeId = choreTypesByChoreTypeId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(Date dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public User getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(User usersByUserId) {
        this.usersByUserId = usersByUserId;
    }

    public User getUsersByUserId_0() {
        return usersByUserId_0;
    }

    public void setUsersByUserId_0(User usersByUserId_0) {
        this.usersByUserId_0 = usersByUserId_0;
    }

    @Override
    public int hashCode() {
        int result = choreId;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (choreTypeId != null ? choreTypeId.hashCode() : 0);
        result = 31 * result + (roomId != null ? roomId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (isActive != null ? isActive.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (dateCompleted != null ? dateCompleted.hashCode() : 0);
        return result;
    }
}
