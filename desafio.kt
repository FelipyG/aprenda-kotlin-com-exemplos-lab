enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nomeUsuario: String, val emailUsuario: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

val curso = object {
    var formacaonome = Formacao("Kotlin", listOf(ConteudoEducacional("Conteúdo 1")), Nivel.AVANCADO )
}

fun main() {
    val usuario1 = Usuario("Fulano de Tal", "email@gmail.com")
	val usuario2 = Usuario("Fulana de Tal", "email2@gmail.com")
	val conteudo1 = ConteudoEducacional("Conteúdo 1", 120)
	val conteudo2 = ConteudoEducacional("Conteúdo 2", 90)
	val formacao = Formacao("Formação Kotlin", listOf(conteudo1, conteudo2), Nivel.AVANCADO)

    formacao.matricular(usuario1)
	formacao.matricular(usuario2)

    val total = "${formacao.nome} de nível ${formacao.nivel} ${formacao.inscritos}"
	println(total)
}
