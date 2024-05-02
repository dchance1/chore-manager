package entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "users", schema = "dbo", catalog = "choresdb")
@org.hibernate.annotations.Entity(
        dynamicInsert = true
)
@NamedQuery(name = "User.orderByName", query = "SELECT tbl FROM User tbl ORDER BY tbl.username")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "role")
    private String role;
    @Basic
    @Column(name = "created_at")
    private String createdAt;

    @Basic
    @Column(name = "first_name")
    private String firstName;

    @Basic
    @Column(name = "last_name")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @OneToMany(mappedBy = "usersByUserId")
    private Collection<Chore> choresById;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (role != null ? !role.equals(user.role) : user.role != null) return false;
        if (createdAt != null ? !createdAt.equals(user.createdAt) : user.createdAt != null) return false;

        return true;
    }

    public Collection<Chore> getChoresById() {
        return choresById;
    }

    public void setChoresById(Collection<Chore> choresById) {
        this.choresById = choresById;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        return result;
    }
}
