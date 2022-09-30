package fikri.kotlin.security

import fikri.kotlin.security.entities.AppUser
import fikri.kotlin.security.entities.Role
import fikri.kotlin.security.repositories.AppUserRepository
import fikri.kotlin.security.repositories.RoleRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ApplicationTests {

	@Autowired
	lateinit var roleRepository: RoleRepository
	@Autowired
	lateinit var appUserRepository: AppUserRepository

	@Test
	fun contextLoads() {
//		val role1 = Role(
//			id=0, name = "Admin"
//		)
//		val role2 = Role(
//			id=0, name = "User"
//		)
//		val role3 = Role(
//			id=0, name = "Manager"
//		)

//		roleRepository.save(role1)
//		roleRepository.save(role2)
//		roleRepository.save(role3)

//		val user1 = AppUser(
//			id=0, name= "Fikri", username = "test", password = ""
//		)
//		user1.roles = setOf(role1, role2)
//		appUserRepository.save(user1)
//
//		val user2 = AppUser(
//			id=0, name= "Ridhwan", username = "test2", password = ""
//		)
//		user2.roles = setOf(role2)
//		appUserRepository.save(user2)

//		val user = appUserRepository.findByUsername("test")
//		val role = roleRepository.findByName("Admin")
//		println(user.toString())
//		println(role.toString())

//		var user = appUserRepository.findByUsername("test")
//		val role = roleRepository.findByName("Manager")
//		if(user.roles.toMutableSet().add(role)){
//			appUserRepository.save(user)
//			println("Success add $role to test")
//		}else{
//			println("failed add $role to test")
//		}
	}

}
