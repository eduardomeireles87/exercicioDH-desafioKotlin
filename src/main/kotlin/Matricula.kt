import java.util.*

class Matricula(var aluno: Aluno, var curso: Curso) {
    private val codigo: String = setDate()

    fun setDate(): String{
        val data = Calendar.getInstance()
        return "${data.get(Calendar.DATE)}${data.get(Calendar.MONTH)+1}${data.get(Calendar.YEAR)}-${data.get(Calendar.MILLISECOND)}"
    }

    override fun toString(): String {
        return """
            Matrícula: ${this.codigo}
            Aluno(a): ${aluno.codigo} - ${aluno.nome} ${aluno.sobrenome}
            Curso: ${curso.codigo} - ${curso.nome}
        """.trimIndent()
    }
}