package com.example.demospringdatajpa.service

import com.example.demospringdatajpa.entity.CustodyEntity
import com.example.demospringdatajpa.repository.CustodyRepository
import org.slf4j.LoggerFactory
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class CustodyService(
        private val repository: CustodyRepository
) {

    private val log = LoggerFactory.getLogger(javaClass)

    fun updatePositionsNoPaged(): Int {
        val list = repository.findAll()
        //list.forEach { println(it) }
        return list.size
    }

    fun updatePositionsPaged(): Int {
        var page = 0
        val size = 1000
        var totalPages = 0
        var totalElements = 0
        val sort = getSort("id", "ASC")
        while(page <= totalPages) {
            repository.findAll(PageRequest.of(page, size, sort)).let {
                totalPages = it.totalPages
                totalElements = it.totalElements.toInt()
            }
            page++
        }
        log.info("TotalPages=$totalPages, page=$page")
        return totalElements
    }

    private fun getSort(sortBy: String, sortDirection: String) =
            if (sortDirection.equals(Sort.Direction.ASC.name, false)) Sort.by(sortBy).ascending() else
                Sort.by(sortBy).descending()

}