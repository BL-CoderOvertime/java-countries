package com.example.kotlincountries

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class CountryController{

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

    @RequestMapping(value = "/names/start/{letter}")
    fun getByLetter(@PathVariable letter:String): ResponseEntity<List<Country>> {
        var sortedList = countryList.sortedWith(compareBy {it.name})
        var filterSortedList = sortedList.filter{it.name.substring(0,1).toLowerCase() == letter}
        return ResponseEntity(filterSortedList,HttpStatus.OK)

    }

    /*/names/size/{number}
    return the countries alphabetically that have a name equal to or longer than the given length*/

    @RequestMapping(value = "/names/size/{number}")
    fun getByNameLength(@PathVariable number:Int): ResponseEntity<List<Country>> {
        var sortedList = countryList.sortedWith(compareBy { it.name })
        var filterSortedList = sortedList.filter { it.name.length <= number }
        return ResponseEntity(filterSortedList, HttpStatus.OK)
    }

   /* /population/size/{people}
    return the countries that have a population equal to or greater than the given population*/

    @RequestMapping(value = "/population/size/{people}")
    fun getByPopulationSize(@PathVariable people:Int): ResponseEntity<List<Country>> {
        var sortedList = countryList.sortedWith(compareBy { it.name })
        var filterSortedList = sortedList.filter { it.population >= people }
        return ResponseEntity(filterSortedList, HttpStatus.OK)
    }


  /*  /population/min
    return the country with the smallest population*/
  @RequestMapping(value = "/population/min")
  fun getBySmallestPopulation(): ResponseEntity<Country> {
      val minPopulation = countryList.minBy { it.population }
      return ResponseEntity(minPopulation, HttpStatus.OK)
  }


    /*/population/max
    return the country with the largest population*/
    @RequestMapping(value = "/population/max")
    fun getByLargestPopulation(): ResponseEntity<Country> {
        val maxPopulation = countryList.maxBy { it.population }
        return ResponseEntity(maxPopulation, HttpStatus.OK)
    }

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
