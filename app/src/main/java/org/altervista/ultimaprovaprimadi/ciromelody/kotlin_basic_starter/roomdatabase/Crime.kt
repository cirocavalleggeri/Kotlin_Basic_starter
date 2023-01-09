package org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.roomdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*
@Entity
data class Crime(@PrimaryKey val id: UUID =UUID.randomUUID(),
                 var title:String="",
                 var date:Date=Date(),
                 var isSolved:Boolean=false,
               //  var isRequiresPolice:Boolean=false
) {
}