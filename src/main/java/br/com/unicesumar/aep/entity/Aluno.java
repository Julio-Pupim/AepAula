package br.com.unicesumar.aep.entity;

import br.com.unicesumar.aep.abstractcrud.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="aluno")
public class Aluno extends AbstractEntity {

  private String nome;

  private String ra;

  public Aluno() {
  }

  public Aluno(String nome, String ra) {
    this.nome = nome;
    this.ra = ra;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getRa() {
    return ra;
  }

  public void setRa(String ra) {
    this.ra = ra;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Aluno aluno = (Aluno) o;
    return Objects.equals(nome, aluno.nome) && Objects.equals(ra, aluno.ra);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nome, ra);
  }
}
