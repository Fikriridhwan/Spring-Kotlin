package fikri.kotlin.security.services.impl

import fikri.kotlin.security.entities.AppUser
import fikri.kotlin.security.entities.Role
import fikri.kotlin.security.repositories.AppUserRepository
import fikri.kotlin.security.repositories.RoleRepository
import fikri.kotlin.security.security.PasswordEncoderDefault
import fikri.kotlin.security.services.UserService
import lombok.extern.slf4j.Slf4j
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
@Slf4j
class UserServiceImpl(
    val appUserRepository: AppUserRepository,
    val roleRepository: RoleRepository,
    val passwordEncoder: PasswordEncoder
//    val passwordEncoder: PasswordEncoder
): UserService, UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val user = appUserRepository.findByUsername(username)
        if(user == null){
            throw UsernameNotFoundException("User not found")
            println("User not found")
        }else{
            println("User found")
        }

        val authorities = mutableListOf<SimpleGrantedAuthority>()
        user.roles.forEach { authorities.add(SimpleGrantedAuthority(it.name)) }
        println(authorities)

        return org.springframework.security.core.userdetails.User(
            user.username, user.password, authorities
        )
    }

    override fun saveUser(user: AppUser): AppUser {
        user.password = passwordEncoder.encode(user.password)
        return appUserRepository.save(user)
    }

    override fun saveRole(role: Role): Role {
        return roleRepository.save(role)
    }

    override fun addRoleToUser(username: String, rolename: String) {
        var user = appUserRepository.findByUsername(username)
        val role = roleRepository.findByName(rolename)
        if(user.roles.toMutableSet().add(role)){
            appUserRepository.save(user)
        }else{
            println("failed add $role to $username")
        }
    }

    override fun getUser(username: String): AppUser {
        return appUserRepository.findByUsername(username)
    }

    override fun getUsers(): List<AppUser> {
        val users = appUserRepository.findAll()
        println(users)
        return users
    }
}