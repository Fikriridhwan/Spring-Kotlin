package fikri.kotlin.security.entities

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
data class AppUser (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    var name: String,
    var username: String,
    var password: String,
){
    @ManyToMany(fetch = FetchType.EAGER)
    lateinit var roles: Collection<Role>
}