package org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.classi

import java.util.*

data class Crime(val id: UUID =UUID.randomUUID(),
                 var title:String="",
                 var date:Date=Date(),
                 var isSolved:Boolean=false,
                 var isRequiresPolice:Boolean=false
) {
}