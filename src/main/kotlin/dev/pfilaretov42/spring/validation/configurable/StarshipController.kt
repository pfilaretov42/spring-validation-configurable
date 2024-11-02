package dev.pfilaretov42.spring.validation.configurable

import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/starship")
class StarshipController {
    @PostMapping("/attack")
    fun hello(@Valid @RequestBody starship: Starship): Unit {
        // attack Arachnids
    }
}