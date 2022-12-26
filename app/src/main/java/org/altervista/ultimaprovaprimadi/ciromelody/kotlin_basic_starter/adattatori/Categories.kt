package org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.adattatori

data  class Categories(val capelli:String,val sciarpe:String,val categoryName:String="capelli") {
    override fun toString(): String {
        return categoryName
    }

}