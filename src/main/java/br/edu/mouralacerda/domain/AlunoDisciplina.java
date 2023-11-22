package br.edu.mouralacerda.domain;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class AlunoDisciplina implements Serializable {
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne
  @JoinColumn(name = "aluno_id")
  @JsonIgnoreProperties("disciplinas")
  private Aluno aluno;

  @ManyToOne
  @JoinColumn(name = "disciplina_id")
  @JsonIgnoreProperties("alunos")
  private Disciplina disciplina;
  
  private double nota1;
  private double nota2;

  public AlunoDisciplina() {
		
	}

	public AlunoDisciplina(int id, Aluno aluno, Disciplina disciplina, double nota1, double nota2) {
		super();
		this.id = id;
		this.aluno = aluno;
		this.disciplina = disciplina;
		this.nota1 = nota1;
		this.nota2 = nota2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public double getNota1() {
		return nota1;
	}

	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}

	public double getNota2() {
		return nota2;
	}

	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlunoDisciplina other = (AlunoDisciplina) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "AlunoDisciplina [id=" + id + ", aluno=" + aluno + ", disciplina=" + disciplina + ", nota1=" + nota1 + ", nota2=" + nota2 + "]";
	}
}


