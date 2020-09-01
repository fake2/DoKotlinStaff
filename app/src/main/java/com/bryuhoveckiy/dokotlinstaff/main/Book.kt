package com.bryuhoveckiy.dokotlinstaff.main

import java.util.*

class Book(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val site: String="",
    private val activityName: String
) {
    val packageName: String
        get() = "com.bryuhoveckiy.dokotlinstaff.$activityName"


    companion object {
        @JvmStatic
        val data: ArrayList<Book>
            get() {
                val books = ArrayList<Book>()
                books.add(
                    Book(
                        title = "Foo",
                        site = "bar",
                        activityName = "foo.FooActivity"
                    )
                )
                books.add(
                    Book(
                        title = "ABC",
                        site = "bar",
                        activityName = "foo.FooActivity"
                    )
                )
                return books
            }
    }

    override fun toString(): String {
        return "Book(id='$id', title='$title', site='$site', activityName='$activityName')"
    }

}