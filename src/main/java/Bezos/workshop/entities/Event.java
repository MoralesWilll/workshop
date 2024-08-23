package Bezos.workshop.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotBlank(message = "Event name is mandatory")
    @Column(length = 225, nullable = false)
    private String name;

    @Future(message = "Event date must be in the future")
    @Column( nullable = false)
    private Date date;

    @NotBlank(message = "Event location is mandatory")
    @Column(length = 225, nullable = false)
    private String location;

    @Column( nullable = false)
    @Min(value = 1, message = "Capacity must be greater than zero")
    private int capacity;

    public Event(String name, Date date, String location, int capacity) {
        this.name = name;
        this.date = date;
        this.location = location;
        this.capacity = capacity;
    }
}
