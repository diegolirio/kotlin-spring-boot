package com.example.demoreadfile

import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject
import org.springframework.web.multipart.MultipartFile
import java.io.ByteArrayInputStream
import java.io.File
import java.io.FileInputStream
import java.io.InputStream


@RestController
@RequestMapping
class CustomerRestController(
    private val layoutClient: LayoutClient
) {

    @GetMapping
    fun get() : List<String> {
        val fileData = layoutClient.get(113)
        read(fileData!!.data)
        return listOf()
    }


    @GetMapping(value = ["/download-file"], produces = [MediaType.APPLICATION_OCTET_STREAM_VALUE] )
    fun download() : ByteArray = layoutClient.get(113)!!.data


    @PutMapping(consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    fun uploadResourceXXX(@RequestPart("file") filePart: MultipartFile): String {
        read(filePart.bytes)
        return "filePart.bytes"
    }

    fun read(fileArray: ByteArray) {
        val input: InputStream = ByteArrayInputStream(fileArray)

        val workbook = XSSFWorkbook(input)
        val sheet = workbook.getSheetAt(0)

        sheet.forEach { row ->
            println(row.getCell(3))
        }
    }
}
