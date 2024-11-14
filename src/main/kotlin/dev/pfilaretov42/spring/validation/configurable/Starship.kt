package dev.pfilaretov42.spring.validation.configurable

import jakarta.validation.constraints.NotBlank
import org.hibernate.validator.constraints.Length

class Starship(
    @field:NotBlank(message = "Starship name cannot be blank")
    @field:Length(min = 10, max = 100, message = "Starship name length must be between {min} and {max}")
    val name: String,
)
