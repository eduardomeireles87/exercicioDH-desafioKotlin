class CodigoEncontrado(): Exception() {

    override val message: String?
        get() = "Cadastro não realizado, pois o código utilizado já consta na base de dados"

}