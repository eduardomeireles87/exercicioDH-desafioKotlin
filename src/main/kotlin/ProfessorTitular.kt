class ProfessorTitular(nome: String,
                       sobrenome: String,
                       tempoDeEmpresa: Int = 0,
                       codigo: Int,
                       var especialidade: String)
    : Professor(nome, sobrenome, tempoDeEmpresa, codigo)
{
    override fun toString(): String {
        return """
            Professor(a) Titular:       ${nome} ${sobrenome}
            Matrícula:                  ${codigo}
            Tempo de empresa:           ${tempoDeEmpresa} meses
            Especiallidade:             ${especialidade}
        """.trimIndent()
    }
}