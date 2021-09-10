abstract class Professor (var nome: String,
                          var sobrenome: String,
                          var tempoDeEmpresa: Int = 0,
                          var codigo: Int) {

    override fun equals(other: Any?): Boolean {
        return (other is Professor && other.codigo == this.codigo)
    }

    override fun hashCode(): Int {
        return codigo
    }
}