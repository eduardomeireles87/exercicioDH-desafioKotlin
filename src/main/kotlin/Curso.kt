class Curso (var nome: String,
             var codigo: Int,
             var professorTitular: ProfessorTitular? = null,
             var professorAdjunto: ProfessorAdjunto? = null,
             var qtdeMaxAlunos: Int,
             val alunos: MutableSet<Aluno> = mutableSetOf<Aluno>()
) {

    fun adicionarUmAluno(aluno: Aluno): Boolean {
        if (alunos.size < qtdeMaxAlunos) {
            alunos.add(aluno)
            return true
        } else {
            return false
        }
    }

    fun excluirAluno(aluno: Aluno){
        try{
            val alunoExiste = alunos.contains(aluno)
            if (alunoExiste) alunos.remove(aluno)
            println("Aluno ${aluno.nome} removido do curso ${this.nome} com sucesso!")
        } catch(e: Exception){
            println("Erro ao excluir aluno ${aluno.nome}: ${e.message}")
        }
    }

    override fun toString(): String {
        return """
            Curso:                  ${nome}
            Código:                 ${codigo}
            Professor(a) Titular:   ${printProfessor(professorTitular)}
            Professor(a) Adjunto:   ${printProfessor(professorAdjunto)}
            Qtd Máx. Alunos:        ${qtdeMaxAlunos}
            Alunos matriculados:    ${alunos.size}
        """.trimIndent()
    }

    override fun equals(other: Any?): Boolean {
        return (other is Curso && other.codigo == this.codigo)
    }

    override fun hashCode(): Int {
        return codigo
    }

    fun printProfessor(professor: Professor?): String{
        if (professor != null){
            return professor.nome
        }
        return "Professor não atribuído"
    }
}