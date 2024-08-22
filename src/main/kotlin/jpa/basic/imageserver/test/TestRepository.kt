package jpa.basic.imageserver.test

import org.springframework.data.jpa.repository.JpaRepository

interface TestRepository : JpaRepository<User, Long> {
}