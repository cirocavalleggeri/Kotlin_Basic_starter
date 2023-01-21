package org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.capitolo10.criminalintent

import java.util.UUID
import java.util.Date

data class Crime(val id: UUID = UUID.randomUUID(),
                 var title: String = "",
                 var date: Date = Date(),
                 var isSolved: Boolean = false)
