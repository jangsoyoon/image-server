package jpa.basic.imageserver.test

import jakarta.persistence.*

@Entity
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(columnDefinition = "varchar(50)")
    var name: String? = null,

    @Column(columnDefinition = "bigint default 0")
    var age: Int? = null,
)