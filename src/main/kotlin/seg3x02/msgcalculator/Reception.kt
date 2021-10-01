package seg3x02.msgcalculator

import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class Reception {
    @RabbitListener(queues = ["calculator-queue"])
    fun receive(msg: String) : String {
        // val user = msg.split(":")[0]
        println(msg)
        return("Received: $msg")
    }
}
