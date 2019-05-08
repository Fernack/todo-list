package mavha.domain.entities;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Base64;

/**
 * Created by fnatalino on 16/4/2019.
 */

@Entity
@Table(name = "TASK")
public class Task {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "DESCRIPCION")
    private String description;

    @Column(name = "ESTADO")
    private Boolean state;

    @Column(name = "IMAGEN", length = 100000000)
    @Lob
    private byte[] image;

    public Task(){}

    public Task(Long id, String description, Boolean state){
        this.id = id;
        this.description = description;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", state=" + state +
                ", image='" + image + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (id != null ? !id.equals(task.id) : task.id != null) return false;
        if (description != null ? !description.equals(task.description) : task.description != null) return false;
        if (state != null ? !state.equals(task.state) : task.state != null) return false;
        return Arrays.equals(image, task.image);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }
}
