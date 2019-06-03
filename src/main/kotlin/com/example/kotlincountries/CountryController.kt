package com.example.kotlincountries

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class EmployeeController{

   /* /names/all
    return the names of all the countries alphabetically*/

    @RequestMapping(value = "/names/all")
    fun getAllNames(): ResponseEntity<*> {
        var sortedList = countryList.sortedWith(compareBy {it.name})
        var countryNames: Array<String?> = arrayOfNulls(countryList.size)

        for ((counter, Country) in sortedList.withIndex()){
            countryNames[counter] = sortedList[counter].name
        }
        return ResponseEntity(countryNames,HttpStatus.OK)
    }


    /* /names/start/{letter}
    return the countries alphabetically that begin with the given letter*/

    /*/names/size/{number}
    return the countries alphabetically that have a name equal to or longer than the given length*/

   /* /population/size/{people}
    return the countries that have a population equal to or greater than the given population*/

  /*  /population/min
    return the country with the smallest population*/

    /*/population/max
    return the country with the largest population*/
    /*/population/median
    return the country with the median population*/

   /* /age/age/{age}
    return the countries that have a median age equal to or greater than the given age*/

    /*/age/min
    return the country with the smallest median age*/

    /*/age/max
    return the country the the greatest median age*/

    /*/age/median
    return the country with the median median age*/

}