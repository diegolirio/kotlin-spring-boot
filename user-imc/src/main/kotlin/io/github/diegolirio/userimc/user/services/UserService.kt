package io.github.diegolirio.userimc.user.services

import io.github.diegolirio.userimc.user.domain.User
import io.github.diegolirio.userimc.user.types.ClassificationType
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun findAll(): MutableIterable<User> {
        return this.userRepository.findAll()
    }

    fun save(user: User): User {
        user.imc = user.weight.div(user.height.times(user.height))
        user.classification = getClassification(user.imc)


        return this.userRepository.save(user)
    }

    private fun getClassification(imc: Float): ClassificationType {
        if(imc < 18.5) {
            return ClassificationType.MAGREZA
        }
        if(imc >= 18.5 && imc < 25) {
            return ClassificationType.NORMAL
        }
        if(imc >= 25 && imc < 30) {
            return ClassificationType.SOBREPESO
        }
        if(imc >= 30 && imc < 40) {
            return ClassificationType.OBESIDADE
        }
        return ClassificationType.OBESIDADE_GRAVE
    }


}
