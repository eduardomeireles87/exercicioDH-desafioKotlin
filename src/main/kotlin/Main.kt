fun main(){
    val dhManager = DigitalHouseManager()

    //Alocar um professor titular e um adjunto para cada curso.
    val titular1 = ProfessorTitular(nome="Eduardo", sobrenome="Meireles", tempoDeEmpresa=2, codigo=43942, especialidade="Full Stack")
    val titular2 = ProfessorTitular(nome="Ricardo", sobrenome="Campos", tempoDeEmpresa=3, codigo=34334, especialidade="Android")
    dhManager.professores.add(titular1)
    dhManager.professores.add(titular2)

    val adjunto1 = ProfessorAdjunto(nome="Luis Otávio", sobrenome="Perez", tempoDeEmpresa=2, codigo=336521, horasMonitoria=240)
    val adjunto2 = ProfessorAdjunto(nome="Valentina", sobrenome="Perez", tempoDeEmpresa=1, codigo=334714, horasMonitoria=1200)
    dhManager.professores.add(adjunto1)
    dhManager.professores.add(adjunto2)

    //Registrar 2 Cursos
    val cursoFullStack = Curso(nome="Full Stack", codigo=20001, qtdeMaxAlunos=3)
    val cursoAndroid = Curso(nome="Android", codigo=20002, qtdeMaxAlunos=2)
    dhManager.cursos.add(cursoFullStack)
    dhManager.cursos.add(cursoAndroid)

    //Excluindo um curso
    val dataScience = Curso(nome="User Experience", codigo=20003, qtdeMaxAlunos=4)
    dhManager.cursos.add(cursoAndroid)
    dhManager.cursos.remove(dataScience)

    //Alocar professores aos respectivos cursos criados
    dhManager.alocarProfessores(codigoCurso=cursoFullStack.codigo, codigoTitular=titular1.codigo, codigoAdjunto=adjunto2.codigo)
    dhManager.alocarProfessores(codigoCurso=cursoAndroid.codigo, codigoTitular=titular2.codigo, codigoAdjunto=adjunto1.codigo)

    //Matricular 2 alunos em Full Stack
    val aluno1 = Aluno(nome="Diogo Enrico", sobrenome="Barbosa", codigo=47357)
    dhManager.matricularAluno(aluno1.nome, aluno1.sobrenome, aluno1.codigo)
    dhManager.matricularAluno(aluno1.codigo, cursoFullStack.codigo)

    val aluno2 = Aluno(nome="Noah", sobrenome="Anthony", codigo=24837)
    dhManager.matricularAluno(aluno2.nome, aluno2.sobrenome, aluno2.codigo)
    dhManager.matricularAluno(aluno2.codigo, cursoFullStack.codigo)

    //Matricular 3 alunos em Android
    val aluno3 = Aluno(nome="Luan", sobrenome="Khalil", codigo=20181)
    dhManager.matricularAluno(aluno3.nome, aluno3.sobrenome, aluno3.codigo)
    dhManager.matricularAluno(aluno3.codigo, cursoAndroid.codigo)

    val aluno4 = Aluno(nome="Tomás", sobrenome="da Luz", codigo=15687)
    dhManager.matricularAluno(aluno4.nome, aluno4.sobrenome, aluno4.codigo)
    dhManager.matricularAluno(aluno4.codigo, cursoAndroid.codigo)

    val aluno5 = Aluno(nome="Otávio", sobrenome="Moraes", codigo=13651)
    dhManager.matricularAluno(aluno5.nome, aluno5.sobrenome, aluno5.codigo)
    dhManager.matricularAluno(aluno5.codigo, cursoAndroid.codigo)

    //excluir Aluno para incluir outro na vaga de Android
    cursoAndroid.excluirAluno(aluno3)
    dhManager.matricularAluno(aluno5.codigo, cursoAndroid.codigo)

    //Prints para confirmação do processo:
    println("---------------------------")
    dhManager.imprimeTodosOsProfessores()
    println("---------------------------")
    dhManager.imprimeTodosOsAlunos()
    println("---------------------------")
    dhManager.imprimeTodosOsCursos()
    println("---------------------------")
    dhManager.imprimeTodasAsMatriculas()


    //Pesquisar curso de um aluno
    println(dhManager.encontrarCursoDoAluno(aluno1.codigo))
    println(dhManager.encontrarCursoDoAluno(11))
}