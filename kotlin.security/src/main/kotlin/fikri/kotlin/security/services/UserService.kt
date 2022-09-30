package fikri.kotlin.security.services

import fikri.kotlin.security.entities.AppUser
import fikri.kotlin.security.entities.Role

interface UserService {
    fun saveUser(user: AppUser): AppUser
    fun saveRole(role: Role): Role
    fun addRoleToUser(username: String, rolename: String)
    fun getUser(username: String): AppUser
    fun getUsers(): List<AppUser>
}