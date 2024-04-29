package entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "chore_types", schema = "dbo", catalog = "choresdb")
@NamedQuery(name = "ChoreType.orderByName", query = "SELECT tbl FROM ChoreType tbl ORDER BY tbl.choreName")
public class ChoreType {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "chore_type_id")
    private int choreTypeId;
    @Basic
    @Column(name = "chore_name")
    private String choreName;
    @Basic
    @Column(name = "chore_type_description")
    private String choreTypeDescription;
    @OneToMany(mappedBy = "choreTypesByChoreTypeId")
    private Collection<Chore> choresByChoreTypeId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChoreType choreType = (ChoreType) o;

        if (choreTypeId != choreType.choreTypeId) return false;
        if (choreName != null ? !choreName.equals(choreType.choreName) : choreType.choreName != null) return false;
        if (choreTypeDescription != null ? !choreTypeDescription.equals(choreType.choreTypeDescription) : choreType.choreTypeDescription != null)
            return false;

        return true;
    }

    public String getChoreName() {
        return choreName;
    }

    public void setChoreName(String choreName) {
        this.choreName = choreName;
    }

    public String getChoreTypeDescription() {
        return choreTypeDescription;
    }

    public void setChoreTypeDescription(String choreTypeDescription) {
        this.choreTypeDescription = choreTypeDescription;
    }

    public int getChoreTypeId() {
        return choreTypeId;
    }

    public void setChoreTypeId(int choreTypeId) {
        this.choreTypeId = choreTypeId;
    }

    public Collection<Chore> getChoresByChoreTypeId() {
        return choresByChoreTypeId;
    }

    public void setChoresByChoreTypeId(Collection<Chore> choresByChoreTypeId) {
        this.choresByChoreTypeId = choresByChoreTypeId;
    }

    @Override
    public int hashCode() {
        int result = choreTypeId;
        result = 31 * result + (choreName != null ? choreName.hashCode() : 0);
        result = 31 * result + (choreTypeDescription != null ? choreTypeDescription.hashCode() : 0);
        return result;
    }
}
