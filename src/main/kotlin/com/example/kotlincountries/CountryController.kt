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

    @RequestMapping(value = "/population/median")
    fun getMedianPopulation(): ResponseEntity<Country> {
        var sortedList = countryList.sortedWith(compareBy { it.population })
        return ResponseEntity(sortedList[sortedList.size/2], HttpStatus.OK)
    }

   /* /age/age/{age}
    return the countries that have a median age equal to or greater than the given age*/

    @RequestMapping(value = "/age/age/{age}")
    fun getByAge(@PathVariable age:Int): ResponseEntity<List<Country>> {
        var sortedList = countryList.sortedWith(compareBy { it.name })
        var filterSortedList = sortedList.filter { it.medianAge >= age }
        return ResponseEntity(filterSortedList, HttpStatus.OK)
    }
    /*/age/min
    return the country with the smallest median age*/

    @RequestMapping(value = "/age/min")
    fun getBySmallestAge(): ResponseEntity<Country> {
        val minAge = countryList.minBy { it.medianAge }
        return ResponseEntity(minAge, HttpStatus.OK)
    }

    /*/age/max
    return the country the the greatest median age*/
    @RequestMapping(value = "/age/max")
    fun getByLargestAge(): ResponseEntity<Country> {
        val maxAge = countryList.maxBy { it.medianAge }
        return ResponseEntity(maxAge, HttpStatus.OK)
    }

    /*/age/median
    return the country with the median median age*/

    @RequestMapping(value = "/age/median")
    fun getMedianAge(): ResponseEntity<Country> {
        var sortedList = countryList.sortedWith(compareBy { it.medianAge })
        return ResponseEntity(sortedList[sortedList.size/2], HttpStatus.OK)
    }

}
