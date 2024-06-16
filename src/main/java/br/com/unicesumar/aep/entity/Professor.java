package br.com.unicesumar.aep.entity;

import br.com.unicesumar.aep.abstractcrud.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "professor")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Professor extends AbstractEntity {

    private String nome;
    private String materia;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "professor", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("professor")
    private List<Aula> aulas;

    public Professor() {
    }

    public Professor(String nome, String materia, List<Aula> aulas) {
        this.nome = nome;
        this.materia = materia;
        this.aulas = aulas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Professor professor = (Professor) o;
        return Objects.equals(nome, professor.nome) && Objects.equals(materia,
            professor.materia) && Objects.equals(aulas, professor.aulas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, materia, aulas);
    }
}
