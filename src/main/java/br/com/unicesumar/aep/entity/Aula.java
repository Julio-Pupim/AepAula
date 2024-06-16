package br.com.unicesumar.aep.entity;

import br.com.unicesumar.aep.abstractcrud.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;
@Entity
@Table(name="aula")
public class Aula extends AbstractEntity {

  @Column(name="titulo_aula")
  private String tituloAula;

  private String url;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="professor_id")
  @JsonIdentityReference(alwaysAsId = true)
  @JsonIgnoreProperties("aulas")
  private Professor professor;

  public Aula() {
  }

  public Aula(String tituloAula, String url, Professor professor) {
    this.tituloAula = tituloAula;
    this.url = url;
    this.professor = professor;
  }

  public String getTituloAula() {
    return tituloAula;
  }

  public void setTituloAula(String tituloAula) {
    this.tituloAula = tituloAula;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Professor getProfessor() {
    return professor;
  }

  public void setProfessor(Professor professor) {
    this.professor = professor;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Aula aula = (Aula) o;
    return Objects.equals(tituloAula, aula.tituloAula) && Objects.equals(url,
        aula.url) && Objects.equals(professor, aula.professor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tituloAula, url, professor);
  }
}
