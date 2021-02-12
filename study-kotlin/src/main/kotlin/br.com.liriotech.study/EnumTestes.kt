package br.com.liriotech.study

enum class Estado {
    SP,
    RJ
}

//enum class Pagamento {
//    CARTAO_CREDITO {
//        override fun pagar() {
//            println(CARTAO_CREDITO)
//        }
//    },
//    DINHEIRO {
//        override fun pagar() {
//            println(DINHEIRO)
//        }
//    },
//    DEBITO {
//        override fun pagar() {
//            println(DEBITO)
//        }
//    },
//    PIX {
//        override fun pagar() {
//            println(PIX)
//        }
//    };
//
//    abstract fun pagar(): Unit
//}

//enum class Pagamento: IPagamento {
//    CARTAO_CREDITO {
//        override fun pagar(): Boolean {
//            println(CARTAO_CREDITO)
//            return true
//        }
//    },
//    DINHEIRO {
//        override fun pagar(): Boolean {
//            println(DINHEIRO)
//            return true
//        }
//    },
//    DEBITO {
//        override fun pagar(): Boolean {
//            println(DEBITO)
//            return true
//        }
//    },
//    PIX {
//        override fun pagar(): Boolean {
//            println(PIX)
//            return true
//        }
//    };
//}

enum class Pagamento {
    CARTAO_CREDITO {
        override fun getPagamento(): IPagamento = PagarComCartaoCredito()
    },
    DINHEIRO {
        override fun getPagamento(): IPagamento = PagarComDinheiro()
    },
    DEBITO {
        override fun getPagamento(): IPagamento = PagarComDebito()
    },
    PIX {
        override fun getPagamento(): IPagamento = PagarComPix()
    };
    abstract fun getPagamento(): IPagamento
}

interface IPagamento {
    fun pagar(): Boolean
}

class PagarComCartaoCredito : IPagamento {
    override fun pagar(): Boolean {
        println("CARTAO_CREDITO")
        return true
    }
}

class PagarComDinheiro : IPagamento {
    override fun pagar(): Boolean {
        println("Money")
        return true
    }
}

class PagarComDebito : IPagamento {
    override fun pagar(): Boolean {
        println("Debito")
        return true
    }
}

class PagarComPix : IPagamento {
    override fun pagar(): Boolean {
        println("Pix ")
        return true
    }
}

fun main() {
    println(Estado.SP)
    println(Estado.RJ)

    val pagto = Pagamento.CARTAO_CREDITO
//    pagto.pagar()
    val pagamentoRealizado = pagto.getPagamento().pagar()
    println(pagamentoRealizado)


}