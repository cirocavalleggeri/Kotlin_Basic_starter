package org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.adattatori

data class Articles(val lavacapelli:String,val arricciacapelli:String,
                    val sciarpe:String,val articleName:String="Lavacapelli") {
    override fun toString(): String {
        return articleName
    }
}