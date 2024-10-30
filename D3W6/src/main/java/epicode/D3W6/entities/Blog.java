package epicode.D3W6.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "blogs")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private int id;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempoDiLettura;

    public Blog(String categoria, String contenuto, String cover, int tempoDiLettura, String titolo) {
        this.categoria = categoria;
        this.contenuto = contenuto;
        this.cover = cover;
        this.tempoDiLettura = tempoDiLettura;
        this.titolo = titolo;
    }

    public void setId(int i) {
    }
}

