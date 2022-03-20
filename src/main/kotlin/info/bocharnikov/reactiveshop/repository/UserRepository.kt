package info.bocharnikov.reactiveshop.repository

import info.bocharnikov.reactiveshop.model.User
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import java.util.*

interface UserRepository : ReactiveCrudRepository<User, UUID>