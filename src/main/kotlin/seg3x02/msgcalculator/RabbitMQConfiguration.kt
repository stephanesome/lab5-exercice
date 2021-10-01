package seg3x02.msgcalculator

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.DirectExchange
import org.springframework.amqp.core.Queue
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMQConfiguration {
    @Bean
    fun queue(): Queue {
        return Queue("calculator-queue", false)
    }

    @Bean
    fun exchange(): DirectExchange {
        return DirectExchange("calculator")
    }

    @Bean
    fun binding(exchange: DirectExchange, queue: Queue): Binding {
        return BindingBuilder.bind(queue)
            .to(exchange)
            .with("calculate")
    }
}
