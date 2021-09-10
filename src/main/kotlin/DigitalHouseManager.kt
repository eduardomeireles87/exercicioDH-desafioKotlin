class DigitalHouseManager() {
    var alunos: MutableSet<Aluno> = mutableSetOf()
    var professores: MutableSet<Professor> = mutableSetOf()
    var cursos: MutableSet<Curso> = mutableSetOf()
    var matriculas: MutableSet<Matricula> = mutableSetOf()

    fun encontrarCurso(codigo: Int): Curso?{
        return cursos.find{it.codigo == codigo}
    }

    fun encontrarProfessor(codigo: Int): Professor?{
        return professores.find{it.codigo == codigo}
    }

    fun encontrarAluno(codigo: Int): Aluno?{
        return alunos.find{it.codigo == codigo}
    }

    fun adicionarMatricula(curso: Curso, aluno: Aluno){
        val haVagas = curso.adicionarUmAluno(aluno)

        if (haVagas){
            curso.alunos.add(aluno)
            val matricula = Matricula(aluno, curso)
            matriculas.add(matricula)
            println("Matrícula de ${matricula.aluno.nome} realizada no curso ${matricula.curso.nome}! ")
        } else {
            println("Erro ao matricular o(a) aluno(a) ${aluno.nome} no curso ${curso.nome}: não há vagas disponíveis")
        }
    }

    fun imprimeTodosOsAlunos(){
        println("Alunos cadastrados:")
        alunos.forEach { aluno -> println("${aluno.toString()}\n") }
    }

    fun imprimeTodosOsProfessores(){
        println("Professores cadastrados:")
        professores.forEach { professor -> println("${professor.toString()}\n") }
    }

    fun imprimeTodosOsCursos(){
        println("Cursos cadastrados:")
        cursos.forEach { curso -> println("${curso.toString()}\n") }
    }

    fun imprimeTodasAsMatriculas(){
        println("Matrículas realizadas:")
        matriculas.forEach { matricula -> println("${matricula.toString()}\n") }
    }

    //Criar um método na classe DigitalHouseManager que permita registrar um
    //curso. O método recebe como parâmetros o nome do curso, o código e a
    //quantidade máxima de alunos admitidos. O método deve criar um curso com
    //os dados correspondentes e adicioná-lo à lista de cursos.

    fun registrarCurso(nome: String, codigoCurso: Int, maxAlunos: Int) {
        val cursoExiste = encontrarCurso(codigoCurso)

        try{
            if (nome.isNotEmpty() && cursoExiste == null) {
                cursos.add(Curso(nome=nome, codigo=codigoCurso, qtdeMaxAlunos=maxAlunos))
            }
        } catch(e: Exception){
            println("Erro ao adicionar curso: ${e.message}")
        }
    }

    //Criar um método na classe DigitalHouseManager que permita excluir um
    //curso. O método recebe como parâmetro o código do curso. O método deve
    //utilizar o código do curso para encontrá-lo na lista de cursos e excluí-lo da
    //lista.

    fun excluirCurso(codigoCurso: Int) {
        val curso = encontrarCurso(codigoCurso)

        try{
            if (curso != null){
                cursos.remove(curso)
            } else {
                throw CodigoEncontrado()
            }
        } catch(e: Exception){
            println("Erro ao excluir curso: ${e.message}")
        }
    }

    //Criar um método na classe DigitalHouseManager que permita registrar um
    //professor adjunto. O método recebe como parâmetros o nome do professor, o
    //sobrenome, o código e a quantidade de horas disponíveis para monitoria. O
    //tempo de casa inicial do professor será zero. O método deve criar um
    //professor adjunto com os dados correspondentes e adicioná-lo à lista de
   //professores.


    fun registrarProfessorAdjunto(nome: String , sobrenome: String , codigoProfessor: Int, qtdeHoras: Int){
        val professor = encontrarProfessor(codigoProfessor)

        try{
            if (professor == null && nome.isNotEmpty()){
                professores.add(ProfessorAdjunto(nome=nome, sobrenome=sobrenome, codigo=codigoProfessor, horasMonitoria=qtdeHoras))
            } else {
                throw CodigoEncontrado()
            }
        } catch (e: Exception){
            println("Erro ao registrar professir adjunto: ${e.message}")
        }
    }

    //Criar um método na classe DigitalHouseManager que permita registrar um
    //professor titular. O método recebe como parâmetros o nome do professor, o
    //sobrenome, o código e a especialidade. O tempo de casa inicial do professor
    //será zero. O método deve criar um professor titular com os dados
    //correspondentes e adicioná-lo à lista de professores.


    fun registrarProfessorTitular(nome: String , sobrenome: String, codigoProfessor: Int, especialidade: String){
        val professor = encontrarProfessor(codigoProfessor)

        try{
            if (professor == null && nome.isNotEmpty()){
                professores.add(ProfessorTitular(nome=nome, sobrenome=sobrenome, codigo=codigoProfessor, especialidade=especialidade))
            } else {
                throw CodigoEncontrado()
            }
        } catch(e: Exception){
            println("Erro ao registrar professor titular: ${e.message}")
        }
    }

    //Criar um método na classe DigitalHouseManager que permita excluir um
    //professor. O método recebe como parâmetro o código do professor. O
    //método deve utilizar o código do professor para encontrá-lo na lista de
    //professores e eliminá-lo da lista.
    //fun excluirProfessor(codigoProfessor: Integer)

    //Criar um método na classe DigitalHouseManager que permita registrar um
    //aluno. O método recebe como parâmetros o nome, o sobrenome e o código
    //do aluno. O método deve criar um aluno com os dados correspondentes e
    //adicioná-lo à lista de alunos.

    fun matricularAluno(nome: String, sobrenome: String, codigoAluno: Int){
        val aluno = encontrarAluno(codigoAluno)

        try{
            if (aluno == null && nome.isNotEmpty()){
                alunos.add(Aluno(nome=nome, sobrenome=sobrenome, codigo=codigoAluno))
            } else {
                throw CodigoEncontrado()
            }
        }catch (e: Exception){
            println("Erro ao registrar aluno: ${e.message}")
        }
    }

    fun matricularAluno(codigoAluno: Int, codigoCurso: Int){
        val curso: Curso? = encontrarCurso(codigoCurso)
        val aluno: Aluno? = encontrarAluno(codigoAluno)

        try{
            if(curso != null && aluno != null){
                adicionarMatricula(curso, aluno)
            }
        } catch(e: Exception){
            println("Erro ao matricular aluno no curso: ${e.message}")
        }
    }

    //Criar um método na classe DigitalHouseManager que permita alocar
    //professores a um curso. O método recebe como parâmetros o código do
    //curso, o código do professor titular e o código do professor adjunto.

    fun alocarProfessores(codigoCurso: Int, codigoTitular: Int, codigoAdjunto: Int){
        val adjunto: Professor? = encontrarProfessor(codigoAdjunto)
        val titular: Professor? = encontrarProfessor(codigoTitular)
        val curso: Curso? = encontrarCurso(codigoCurso)

        try{
            if (adjunto != null && titular != null){
                if (curso != null){
                    curso.professorAdjunto = adjunto as ProfessorAdjunto?
                    curso.professorTitular = titular as ProfessorTitular?
                }
            }
        } catch (e: Exception){
            println("Erro ao alocar professores no curso: ${e.message}")
        }
    }

    fun encontrarCursoDoAluno(codigoAluno: Int): String{
        val aluno = encontrarAluno(codigoAluno)
        val matricula = matriculas.find { it.aluno.codigo == codigoAluno }
        val curso = matricula?.curso?.nome

        when {
            aluno != null && curso != null -> return "Aluno matriculado no curso de ${curso}"
            aluno == null -> return "Aluno não possui matrícula ativa"
            else -> return "Aluno não está associado a nenhum curso cadastrado"
        }

    }

}