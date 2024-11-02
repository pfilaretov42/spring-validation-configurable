package dev.pfilaretov42.spring.validation.configurable

import jakarta.validation.constraints.NotBlank
import org.hibernate.validator.constraints.Length

class Starship(
    @field:NotBlank(message = "Starship name cannot be blank")
    @field:Length(min = 3, max = 20, message = "Starship name must be between 3 and 20")
    val name: String,
)
