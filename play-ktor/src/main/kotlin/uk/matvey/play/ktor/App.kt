package uk.matvey.play.ktor

import io.ktor.server.application.ApplicationCallPipeline.ApplicationPhase.Call
import io.ktor.server.application.call
import io.ktor.server.application.install
import io.ktor.server.auth.Authentication
import io.ktor.server.auth.AuthenticationContext
import io.ktor.server.auth.AuthenticationProvider
import io.ktor.server.auth.Principal
import io.ktor.server.auth.authenticate
import io.ktor.server.auth.principal
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.response.respondText
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

fun main() {
    embeddedServer(Netty, port = 8080) {
        install(Authentication) {
            register(AuthProvider)
        }
        routing {
            get("/") {
                call.respondText("Hello, world!")
            }
            authenticate("user") {
                auth("auth-0") {
                    get("/protected") {
                        call.respondText("Protected")
                    }
                    auth("auth-1", "auth-2") {
                        get("/super-protected") {
                            call.respondText("Super protected")
                        }
                    }
                }
            }
        }
    }.start(wait = true)
}

data class User(val name: String) : Principal

object AuthProvider : AuthenticationProvider(object : Config("user") {}) {
    override suspend fun onAuthenticate(context: AuthenticationContext) {
        println("AUTH-0")
        context.principal(User("user-0"))
    }
}

fun Route.auth(vararg names: String, build: Route.() -> Unit) {
    intercept(Call) {
        println("Intercepted ${names.toList()}")
        println(call.principal<User>())
    }
    build()
}
