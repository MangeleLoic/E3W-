package epicode.D3W6.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
@Getter
@Setter
@ToString
@AllArgsConstructor
public class NewBloggerPayload {
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
    private  String avatar;
}
