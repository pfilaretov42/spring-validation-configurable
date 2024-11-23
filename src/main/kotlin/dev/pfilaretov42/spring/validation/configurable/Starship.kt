package dev.pfilaretov42.spring.validation.configurable

import jakarta.validation.Constraint
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import jakarta.validation.constraints.NotBlank
import org.springframework.core.env.Environment
import kotlin.reflect.KClass


class Starship(
    @field:NotBlank(message = "Starship name cannot be blank")
    @field:StarshipName(min = "\${starship.name.length.min}", max = "\${starship.name.length.max}")
    val name: String,
)

@MustBeDocumented
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [StarshipNameValidator::class])
annotation class StarshipName(
    val min: String = "1",
    val max: String = "10",
    val message: String = "Starship name length is invalid (min={min}, max={max})",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<*>> = [],
)

class StarshipNameValidator(private val env: Environment) : ConstraintValidator<StarshipName, String> {

    private var min = 1
    private var max = 10

    override fun initialize(constraintAnnotation: StarshipName) {
        min = env.resolvePlaceholders(constraintAnnotation.min).toInt()
        max = env.resolvePlaceholders(constraintAnnotation.max).toInt()
    }

    override fun isValid(value: String?, context: ConstraintValidatorContext): Boolean =
        value?.let { it.length in min..max } ?: false

}