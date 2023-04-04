package template.springbootjpatemplate.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class SampleModel {

    @Id
    private Long id;
    private String name;
    private String email;

    public SampleModel() { }

    public SampleModel(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
