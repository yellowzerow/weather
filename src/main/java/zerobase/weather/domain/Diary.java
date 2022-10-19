package zerobase.weather.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Diary")
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String weather;
    private String icon;
    private double temperature;
    private String text;
    private LocalDate date;

}
