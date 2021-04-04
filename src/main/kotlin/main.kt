fun main() {
    println("Bem vindo ao Bytebank")
    val contaLeandro = Conta(titular = "Leandro", numero = 1000)
    contaLeandro.deposita(200.0)

    val contaAlex = Conta(titular = "Alex", numero = 1001)
    contaAlex.deposita(300.0)

    println("Nome do titular: ${contaLeandro.titular}")
    println("Número da conta: ${contaLeandro.numero}")
    println("Saldo da conta: ${contaLeandro.saldo}")

    println("Nome do titular: ${contaAlex.titular}")
    println("Número da conta: ${contaAlex.numero}")
    println("Saldo da conta: ${contaAlex.saldo}")

    contaLeandro.deposita(50.0)
    contaAlex.deposita(70.0)
    contaLeandro.saca(250.0)
    contaAlex.saca(100.0)
    contaLeandro.saca(100.0)
    contaAlex.saca(500.0)
    contaAlex.transfere(100.0, contaLeandro)
    contaLeandro.transfere(150.0, contaAlex)
}

class Conta(val titular: String, val numero: Int) {
    var saldo = 0.0
        private set

    fun deposita(valor: Double) {
        if (valor > 0) {
            this.saldo += valor
            println("Depositando o valor de $valor na conta do $titular, saldo atual $saldo")
        } else println("Não é possível depositar um valor negativo para conta do $titular, saldo atual $saldo")
    }

    fun saca(valor: Double) {
        if (saldo >= valor) {
            saldo -= valor
            println("Sacando o valor de $valor na conta do $titular, saldo atual $saldo")
        } else println("Saldo insuficiente para saque de $valor na conta do $titular, o saldo atual é $saldo")
    }

    fun transfere(valor: Double, destino: Conta) {
        if (saldo >= valor) {
            saldo -= valor
            destino.deposita(valor)
            println("Transferindo o valor de $valor da conta do $titular para conta do ${destino.titular}, saldo atual $saldo")
        } else println("Saldo insuficiente para transferência de $valor da conta do $titular para conta do ${destino.titular}, o saldo atual é $saldo")
    }
}

fun testaCopiasEReferencias() {
    val numeroX = 10
    var numeroY = numeroX
    numeroY++

    val contaJoao = Conta(titular = "João", numero = 1002)
    var contaMaria = Conta(titular = "Maria", numero = 1003)

    println("Titular conta joao: ${contaJoao.titular}")
    println("Titular conta maria: ${contaMaria.titular}")

    println(contaJoao)
    println(contaMaria)
}

fun testaLacos() {
    var i = 0
    while (i < 5) {
        val titular = "Leandro $i"
        val numeroConta = 1000 + i
        var saldo = i + 10.0

        println("Titular: $titular")
        println("Número da Conta: $numeroConta")
        println("Saldo: $saldo")
        println()
        i++
    }

    for (i in 5 downTo 1) {

        val titular = "Leandro $i"
        val numeroConta = 1000 + i
        var saldo = i + 10.0

        println("Titular: $titular")
        println("Número da Conta: $numeroConta")
        println("Saldo: $saldo")
        println("")
    }
}

fun testaCondicoes(saldo: Double) {
    if (saldo > 0.0) {
        println("Conta é positiva")
    } else if (saldo == 0.0) {
        println("Conta é neutra")
    } else {
        println("Conta é negativa")
    }

    when {
        saldo > 0.0 -> println("Conta é positiva")
        saldo == 0.0 -> println("Conta é neutra")
        else -> println("Conta é negativa")
    }
}