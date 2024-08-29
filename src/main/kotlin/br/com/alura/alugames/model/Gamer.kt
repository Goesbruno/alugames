package br.com.alura.alugames.model

import java.lang.IllegalArgumentException
import java.util.Scanner
import kotlin.random.Random

data class Gamer(
    var name: String,
    var email: String
) : Recommendable {
    var birthDate: String? = null
    var user: String? = null
        set(value) {
            field = value
            if (internalId.isNullOrBlank()) internIdCreator()
        }
    var internalId:String? = null
        private set
    var plan: Plan = PlanAvulso("BRONZE")

    val searchedGames = mutableListOf<Game?>()
    val rentedGames = mutableListOf<Rent?>()
    private val ratingList = mutableListOf<Int>()
    val recommendedGames = mutableListOf<Game>()
    override val average: Double
        get() = ratingList.average()

    override fun recommend(rating: Int) {
        if (rating < 1 || rating > 10){
            println("Nota Inválida")
        } else ratingList.add(rating)
    }

    fun gameRecommend(game: Game, rating: Int){
        game.recommend(rating)
        recommendedGames.add(game)
    }


    constructor(
        name: String,
        email: String,
        birthDate: String,
        user: String
    ) : this(name, email) {
        this.birthDate = birthDate
        this.user = user
        internIdCreator()
    }

    init {
        if (name.isNullOrBlank()) throw IllegalArgumentException("Nome não pode estar em branco")
        this.email = emailValidation()
    }

    override fun toString(): String {
        return "Gamer:\n" +
                "Nome: $name,\n" +
                "Email: $email,\n" +
                "Data Nascimento: $birthDate,\n" +
                "Usuário: $user,\n" +
                "ID Interno: $internalId,\n" +
                "Reputação: $average"

    }

    fun internIdCreator(){
        val number = Random.nextInt(10000)
        val tag = String.format("%04d", number)

        internalId = "$user#$tag"
    }

    fun gamesOfTheMonth(month:Int): List<Game> {
        return rentedGames
            .filter { rent ->  rent!!.period.inicialDate.monthValue == month}
            .map { rent ->  rent!!.game}
    }
    fun emailValidation() : String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (regex.matches(email))
            return email
        else throw IllegalArgumentException("Insira um e-mail válido")
    }

    fun rentGame(game: Game, period: Period): Rent {
        val rent = Rent(this, game, period)
        rentedGames.add(rent)
        return rent
    }

    companion object {
        fun gamerCreate(imput: Scanner): Gamer {
            println("Boas vindas ao AluGames! Vamos fazer seu cadastro. Digite seu nome:")
            val name = imput.nextLine()
            println("Digite seu e-mail:")
            val email = imput.nextLine()
            println("Deseja completar seu cadastro com usuário e data de nascimento? S/N")
            val option = imput.nextLine()

            return if (option.equals("s", true)){
                println("Digite sua data de nascimento (DD/MM/AAAA)")
                val birthDate = imput.nextLine()
                println("Digite seu nome de usuário:")
                val user = imput.nextLine()

                Gamer(name, email, birthDate, user)
            } else {
                Gamer(name,email)
            }
        }
    }
}
