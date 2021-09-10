class Aluno (var nome: String, var sobrenome: String, var codigo: Int) {

    override fun toString(): String {
        return """
            Código: ${codigo}    
            Aluno(a): ${nome} ${sobrenome}
        """.trimIndent()
    }

    override fun equals(other: Any?): Boolean {
        return (other is Aluno && other.codigo == this.codigo)
    }

    override fun hashCode(): Int {
        return codigo
    }
}