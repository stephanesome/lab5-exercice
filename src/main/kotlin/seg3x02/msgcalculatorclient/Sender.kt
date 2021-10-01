package seg3x02.msgcalculatorclient

import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class Sender(val template: RabbitTemplate): CommandLineRunner {
    override fun run(vararg args: String?) {
        val msg = readLine()
        val res = template.convertSendAndReceive("calculator", "calculate", msg!!)
        println(res)
    }
}
