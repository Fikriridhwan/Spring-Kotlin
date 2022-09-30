package fikri.kotlin.security.controllers

import fikri.kotlin.security.dto.RoleToUserRequest
import fikri.kotlin.security.entities.AppUser
import fikri.kotlin.security.entities.Role
import fikri.kotlin.security.services.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

@RestController
@RequestMapping("/api")
class UserController(
    val userService: UserService
) {

    @GetMapping("/users")
    fun getUsers(): ResponseEntity<List<AppUser>> = ResponseEntity.ok().body(userService.getUsers())

    @PostMapping("/user/save")
    fun saveUsers(@RequestBody appUser: AppUser): ResponseEntity<AppUser>{
        val uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString())
        return ResponseEntity.created(uri).body(userService.saveUser(appUser))
    }

    @PostMapping("/role/save")
    fun saveRole(@RequestBody role: Role): ResponseEntity<Role>{
        val uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString())
        return ResponseEntity.created(uri).body(userService.saveRole(role))
    }

    @PostMapping("/role/addtouser")
    fun addToUser(@RequestBody roleToUserRequest: RoleToUserRequest): ResponseEntity<Role>{
        userService.addRoleToUser(roleToUserRequest.username, roleToUserRequest.rolename)
        return ResponseEntity.ok().build()
    }
}