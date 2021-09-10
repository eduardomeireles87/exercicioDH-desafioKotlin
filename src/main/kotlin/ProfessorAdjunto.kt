class ProfessorAdjunto(nome: String,
                       sobrenome: String,
                       tempoDeEmpresa: Int = 0,
                       codigo: Int,
                       var horasMonitoria: Int)
    : Professor(nome, sobrenome, tempoDeEmpresa, codigo)
{
    override fun toString(): String {
        return """
            Professor(a) Adjunto:       ${nome} ${sobrenome}
            Matrícula:                  ${codigo}
            Tempo de empresa:           ${tempoDeEmpresa} meses
            Horas de monitoria:         ${horasMonitoria} h
        """.trimIndent()
    }
}