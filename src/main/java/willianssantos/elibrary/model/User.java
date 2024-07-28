package willianssantos.elibrary.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Reading> readings = new ArrayList<>(); // Lista de leituras do usuário

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Reading> getReadings() {
        return readings;
    }

    public void setReadings(List<Reading> readings) {
        this.readings = readings;
    }

    // Método para adicionar uma leitura à lista do usuário
    public void addReading(Reading reading) {
        this.readings.add(reading);
    }
}
